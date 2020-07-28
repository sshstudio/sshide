package ru.openitstudio.cron;

import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronDefinitionBuilder;

import static com.cronutils.model.CronType.UNIX;

public class Main {

    public static void main(String[] args) {
        // Define your own cron: arbitrary fields are allowed and last field can be optional
        CronDefinition cronDefinition =
                CronDefinitionBuilder.defineCron()
                        .withSeconds().and()
                        .withMinutes().and()
                        .withHours().and()
                        .withDayOfMonth()
                        .supportsHash().supportsL().supportsW().and()
                        .withMonth().and()
                        .withDayOfWeek()
                        .withIntMapping(7, 0) //we support non-standard non-zero-based numbers!
                        .supportsHash().supportsL().supportsW().and()
                        .withYear().optional().and()
                        .instance();

// or get a predefined instance
        cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(UNIX);
    }
}
