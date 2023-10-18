package com.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.facebook.ads.sdk.*;

public class HelloWorld {
    public static final APIContext context = new APIContext(
        ""
    );

    public static void main(String[] args) {
        System.out.println("Hello World");
        try {

            AdAccount account = new AdAccount("", context);
            APINodeList<Campaign> campaigns = account.getCampaigns().execute();

            List<String> ids = new ArrayList<>();
            for (var campaign : campaigns) {
                ids.add(campaign.getId());
            }

            APINodeList<Campaign> campaign_details = Campaign.fetchByIds(
                ids,
                Arrays.asList(
                    "id",
                    "name"
                ),
                context
            );

            for (var campaign : campaign_details) {
                System.out.println(campaign.getId() + ":" + campaign.getFieldName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
