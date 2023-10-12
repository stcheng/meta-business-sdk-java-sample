package com.example;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APINodeList;

import com.facebook.ads.sdk.ProductCatalog;
import com.facebook.ads.sdk.ProductItem;

public class HelloWorld {
    public static final APIContext context = new APIContext(
        ""
    );

    public static void main(String[] args) {
        System.out.println("Hello World");
        try {

            ProductCatalog pc = new ProductCatalog("", context).get().requestFields(Arrays.asList("id", "name")).execute();
            System.out.println(pc);
            APINodeList<ProductItem> pis = pc.getProducts().requestFields(Arrays.asList("id","name","capability_to_review_status","retailer_id","retailer_product_group_id")).setParam("limit", 200).execute();

            while (pis != null) {
                for (ProductItem pi : pis) {
                    if (pi.getFieldCapabilityToReviewStatus()==null) {
                        System.out.println(pi);
                    }

                }
                pis = pis.nextPage();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("----------");
    }
}
