package ru.openitstudio.sshide.components.main;

import ru.openitstudio.sshide.components.newsession.*;

import javax.swing.*;
import javax.swing.tree.*;
import java.util.UUID;

public class ConnectionsTree extends JPanel {

    private DefaultTreeModel treeModel;
    private JTree tree;
    private DefaultMutableTreeNode rootNode;
    private String lastSelected;

    public ConnectionsTree() {
        init();
    }

    private void init() {

        treeModel = new DefaultTreeModel(null, true);
//        treeModel.addTreeModelListener(this);
        tree = new AutoScrollingJTree(treeModel);
        tree.setDragEnabled(true);
        tree.setDropMode(DropMode.ON_OR_INSERT);
        tree.setTransferHandler(new TreeTransferHandler());
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
//        tree.getSelectionModel().addTreeSelectionListener(this);
        // tree.setDragEnabled(true);

        tree.setEditable(false);


        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) tree.getCellRenderer();
        Icon closedIcon = new ImageIcon(getClass().getResource("/icons/server-group.png"));
        Icon openIcon = new ImageIcon(getClass().getResource("/icons/server-group.png"));
        Icon leafIcon = new ImageIcon(getClass().getResource("/icons/server.png"));
        renderer.setClosedIcon(closedIcon);
        renderer.setOpenIcon(openIcon);
        renderer.setLeafIcon(leafIcon);


        loadTree(SessionStore.load());

        add(new JScrollPane(tree));
    }

    private void loadTree(SavedSessionTree stree) {
        this.lastSelected = stree.getLastSelection();
        rootNode = SessionStore.getNode(stree.getFolder());
        rootNode.setAllowsChildren(true);
        treeModel.setRoot(rootNode);
        try {
            if (this.lastSelected != null) {
                selectNode(lastSelected, rootNode);
            } else {
                DefaultMutableTreeNode n = null;
                n = findFirstInfoNode(rootNode);
                if (n == null) {
                    SessionInfo sessionInfo = new SessionInfo();
                    sessionInfo.setName("New site");
                    sessionInfo.setId(UUID.randomUUID().toString());
                    DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(sessionInfo);
                    childNode.setUserObject(sessionInfo);
                    childNode.setAllowsChildren(false);
                    treeModel.insertNodeInto(childNode, rootNode, rootNode.getChildCount());
                    n = childNode;
                    tree.scrollPathToVisible(new TreePath(n.getPath()));
                    TreePath path = new TreePath(n.getPath());
                    tree.setSelectionPath(path);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        treeModel.nodeChanged(rootNode);
    }

    private boolean selectNode(String id, DefaultMutableTreeNode node) {
        if (id.equals((((NamedItem) node.getUserObject()).getId()))) {
            tree.setSelectionPath(new TreePath(node.getPath()));
            return true;
        }
        for (int i = 0; i < node.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
            if (selectNode(id, child)) {
                return true;
            }
        }
        return false;
    }

    private DefaultMutableTreeNode findFirstInfoNode(DefaultMutableTreeNode node) {
        if (!node.getAllowsChildren()) {
            return node;
        } else {
            for (int i = 0; i < node.getChildCount(); i++) {
                DefaultMutableTreeNode child = findFirstInfoNode((DefaultMutableTreeNode) node.getChildAt(i));
                if (child != null) {
                    return child;
                }
            }
        }
        return null;
    }
}
