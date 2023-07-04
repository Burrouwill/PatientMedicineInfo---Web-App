package com.example.demo.Adr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AdrConfig {

    @Bean
    CommandLineRunner commandLineRunner2(AdrRepository repository) {
        return args -> {

            /*
            Drug Specific Adrs to be added:

            warfarin, ciclosporin, oral contraceptives, s monoamine oxidase inhibitors (MAOIs) and tyramine containing foods

             */

            Adr CAL1 = new Adr(
                    "This medicine may make you sleepy and make it dangerous to drive or operate machinery.",
                    "Limit alcohol intake. Check if this medicine makes you drowsy / sleepy before " +
                            "operating machinery or driving"
            );

            Adr CAL2 = new Adr(
                    "Interacts with Alcohol",
                    "Do not drink alcohol while being treated with this medicine."
            );

            Adr CAL3 = new Adr(
                    "This medicine works best on an empty stomach.",
                    "Take each dose on an empty stomach - one hours before OR two hours after food."
            );

            Adr FOOD = new Adr(
                    "Best taken with food.",
                    "Taking each dose with food will help prevent an upset stomach."
            );

            Adr CAL4 = new Adr(
                    "Interacts with Antacids.",
                    "Do not take indigestion / heartburn remedies, iron or calcium preparations" +
                            " within two hours of taking this medicine."
            );

            Adr CAL5 = new Adr(
                    "Take this medicine until it is finished.",
                    "It is important to finish the course of this medicine so that your infection is treated and does" +
                            "not come back. This also helps to slow microbial resistance to these kinds of medicines, ensuring" +
                            "that they will continue to work for other patients in the future."
            );

            Adr CAL6 = new Adr(
                    "Must be kept in the Fridge.",
                    "Keep this medicine in the fridge, do not freeze it - this will damage the " +
                            "medicine and cause it not to work properly.this means between 2º and 8ºC."
            );

            Adr CAL7 = new Adr(
                    "Do not use if expired.",
                    "Some medicines have a short shelf-life, make sure to check it is still within date."
            );

            Adr CAL8 = new Adr(
                    "This medicine can cause you to get sunburnt more quickly.",
                    "Protect yourself from too much natural or artificial sunlight while being treated with this medicine." +
                            "This includes sunbeds."
            );

            Adr CAL9 = new Adr(
                    "Do not stop taking this medicine.",
                    "Immediately stopping taking this medicine can cause a withdrawal reaction. " +
                            "This reaction can make your condition worse and potentially cause other side effects. \n" +
                            "Talk to your Doctor or Pharmacist before stopping so they can help you make a plan to do it safely."
            );

            Adr CAL10 = new Adr(
                    "Take each dose with a large glass of water.",
                    "This medicine can cause side effects if it gets stuck in your throat. Taking this medicine" +
                            "with a large glass of water while standing up will help prevent this."
            );

            Adr CAL11 = new Adr(
                    "Do not eat anything containing grapefruit or grapefruit juice.",
                    "Eating or drinking products that contain regular or pink grapefruit can make this medicine stop" +
                            "working. "
            );

            Adr CAL13 = new Adr(
                    "For external use only.",
                    "This medicine is not to be eaten. Refer to the personal instructions on the label for how to apply it."
            );

            Adr CAL14 = new Adr(
                    "Shake the bottle before each dose.",
                    "Shaking the bottle helps ensure that the medicine is mixed properly so that you get the correct dose. "
            );

            Adr WHOLE= new Adr(
                    "Swallow whole, do not crush or chew.",
                    "This medicine has a special coating, which helps it work. Crushing or chewing can cause this medicine to" +
                            "not work properly and might cause side effects. "
            );


            repository.saveAll(List.of(CAL1, CAL2, CAL3, CAL4, CAL5, CAL6, CAL7, CAL8, CAL9, CAL10, CAL11, CAL13, CAL14, FOOD, WHOLE));
        };
    }
}
