package imageviewer.persistence.web;

import imageviewer.model.Image;
import imageviewer.persistence.ImageLoader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WebImageLoader implements ImageLoader {
    private List<String> urls;

    public WebImageLoader(String text) {
        this.urls = search(text);
    }
    
    

    @Override
    public Image load() {
        return imageAt(0);
    }

    private Image imageAt(final int index) {
        return new Image() {

            @Override
            public InputStream inputStream() {
                try {
                    return new URL(urls.get(index)).openStream();
                } catch (IOException ex) {
                    return null;
                }
            }

            @Override
            public Image next() {
                if (index == urls.size() - 1) return imageAt(0);
                return imageAt(index+1);
            }

            @Override
            public Image prev() {
                if (index == 0) return imageAt(urls.size() - 1);
                return imageAt(index-1);
            }
        };
    }

    private List<String> search(String text) {
        String json = get(text);
        Scanner scanner = new Scanner(get(text));
        List<String> result = new ArrayList<>();
        boolean sentinel = false;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.contains("\"uri\"")) continue;
            sentinel = !sentinel;
            if (!sentinel) continue;
            result.add(line.substring(line.indexOf("http")).replace("\"",""));
        }
        return result;
    }

    private String get(String text) {
        return "{\n" +
"  \"result_count\": 62579,\n" +
"  \"images\": [\n" +
"    {\n" +
"      \"id\": \"667719879\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache3.asset-cache.net/xt/667719879.jpg?v=1&g=fs1|0|EYM|19|879&s=1&b=RjI4\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/photo/close-up-of-penguins-on-rock-royalty-free-image/667719879\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Close-Up Of Penguins On Rock\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"683810271\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache1.asset-cache.net/xt/683810271.jpg?v=1&g=fs1|0|EYM|10|271&s=1&b=RjI4\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/photo/penguins-against-rock-formation-royalty-free-image/683810271\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Penguins Against Rock Formation\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"518680544\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache2.asset-cache.net/xt/518680544.jpg?v=1&g=fs1|0|SKP255|80|544&s=1&b=NzU1\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"thinkstock\",\n" +
"          \"uri\": \"http://www.thinkstockphotos.com/image/stock-photo-adelie-penguin-jumping-between-two-ice-floes/518680544\"\n" +
"        },\n" +
"        {\n" +
"          \"site_name\": \"istockphoto\",\n" +
"          \"uri\": \"http://www.istockphoto.com/photo/adelie-penguin-jumping-between-two-ice-floes-gm518680544-90169535\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Pingüino de adelia salto entre dos témpanos de hielo\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"675592785\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache3.asset-cache.net/xt/675592785.jpg?v=1&g=fs1|0|EYM|92|785&s=1&b=RjI4\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/photo/low-angle-view-of-penguin-l-oceanografic-royalty-free-image/675592785\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Low Angle View Of Penguin L Oceanografic\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"167450110\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache4.asset-cache.net/xt/167450110.jpg?v=1&g=fs1|0|NG|50|110&s=1&b=RTRE\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/photo/penguins-swim-at-the-surface-which-loads-high-res-stock-photography/167450110\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Penguins swim at the surface, which loads their plumage with air.\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"556445777\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache1.asset-cache.net/xt/556445777.jpg?v=1&g=fs1|0|NG|45|777&s=1&b=RTRE\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/photo/gentoo-penguins-pygoscelis-papua-and-high-res-stock-photography/556445777\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Gentoo penguins, Pygoscelis papua, and chinstrap penguins, Pygoscelis antarctica, on an ice floe.\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"620934936\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache1.asset-cache.net/xt/620934936.jpg?v=1&g=fs2|0|editorial538|34|936&s=1&b=OA==\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/news-photo/baby-little-blue-penguins-at-melbourne-zoo-on-november-4-news-photo/620934936\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Baby Animals On Display At Melbourne Zoo\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"620934906\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache4.asset-cache.net/xt/620934906.jpg?v=1&g=fs2|0|editorial538|34|906&s=1&b=OA==\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/news-photo/baby-little-blue-penguins-at-melbourne-zoo-on-november-4-news-photo/620934906\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Baby Animals On Display At Melbourne Zoo\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"167449896\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache1.asset-cache.net/xt/167449896.jpg?v=1&g=fs1|0|NG|49|896&s=1&b=RTRE\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/photo/emperor-penguins-are-capable-of-diving-to-1-high-res-stock-photography/167449896\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Emperor penguins are capable of diving to 1,750 feet.\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"489175330\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache3.asset-cache.net/xt/489175330.jpg?v=1&g=fs1|0|SKP215|75|330&s=1&b=NkYy\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"thinkstock\",\n" +
"          \"uri\": \"http://www.thinkstockphotos.com/image/stock-illustration-penguin-flat-style-vector-illustration/489175330\"\n" +
"        },\n" +
"        {\n" +
"          \"site_name\": \"istockphoto\",\n" +
"          \"uri\": \"http://www.istockphoto.com/vector/penguin-flat-style-vector-illustration-gm489175330-74570603\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Pingüino. Estilo plano. Ilustración vectorial.\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"167450114\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache4.asset-cache.net/xt/167450114.jpg?v=1&g=fs1|0|NG|50|114&s=1&b=RTRE\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/photo/emperor-penguins-are-capable-of-diving-to-1-high-res-stock-photography/167450114\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Emperor penguins are capable of diving to 1,750 feet.\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"596046800\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache1.asset-cache.net/xt/596046800.jpg?v=1&g=fs1|0|SKP358|46|800&s=1&b=MDgx\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"istockphoto\",\n" +
"          \"uri\": \"http://www.istockphoto.com/photo/penguin-floating-underwater-gm596046800-102167731\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Pingüino flotante submarino\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"537076065\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache4.asset-cache.net/xt/537076065.jpg?v=1&g=fs1|0|EPL|76|065&s=1&b=RjI4\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/photo/penguins-on-winter-tundra-royalty-free-image/537076065\"\n" +
"        },\n" +
"        {\n" +
"          \"site_name\": \"istockphoto\",\n" +
"          \"uri\": \"http://www.istockphoto.com/photo/penguins-on-winter-tundra-gm537076065-58090264\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Pingüinos en invierno Tundra\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"477406001\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache4.asset-cache.net/xt/477406001.jpg?v=1&g=fs1|0|SKP199|06|001&s=1&b=MTRD\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"thinkstock\",\n" +
"          \"uri\": \"http://www.thinkstockphotos.com/image/stock-photo-emperor-penguins/477406001\"\n" +
"        },\n" +
"        {\n" +
"          \"site_name\": \"istockphoto\",\n" +
"          \"uri\": \"http://www.istockphoto.com/photo/emperor-penguins-gm477406001-35667110\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Pingüinos emperados\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"611483343\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache2.asset-cache.net/xt/611483343.jpg?v=1&g=fs1|0|EYM|83|343&s=1&b=RjI4\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/photo/penguin-swimming-in-aquarium-royalty-free-image/611483343\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Penguin Swimming In Aquarium\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"493056068\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache4.asset-cache.net/xt/493056068.jpg?v=1&g=fs1|0|SKP220|56|068&s=1&b=Qzcw\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"thinkstock\",\n" +
"          \"uri\": \"http://www.thinkstockphotos.com/image/stock-photo-emperor-penguin-chicks/493056068\"\n" +
"        },\n" +
"        {\n" +
"          \"site_name\": \"istockphoto\",\n" +
"          \"uri\": \"http://www.istockphoto.com/photo/emperor-penguin-chicks-gm493056068-76698321\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Pingüino emperador pollos\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"537011727\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache4.asset-cache.net/xt/537011727.jpg?v=1&g=fs1|0|LRM|11|727&s=1&b=RjI4\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/photo/adelie-penguin-antarctic-peninsula-high-res-stock-photography/537011727\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Adelie Penguin (Pygoscelis adeliae), Antarctic Peninsula, Antarctica\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"138821149\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache4.asset-cache.net/xt/138821149.jpg?v=1&g=fs1|0|FKM|21|149&s=1&b=RjI4\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/photo/three-penguins-high-res-stock-photography/138821149\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Three penguins\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"611483337\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache3.asset-cache.net/xt/611483337.jpg?v=1&g=fs1|0|EYM|83|337&s=1&b=RjI4\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/photo/close-up-of-penguin-swimming-in-sea-royalty-free-image/611483337\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Close-Up Of Penguin Swimming In Sea\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"504247348\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache4.asset-cache.net/xt/504247348.jpg?v=1&g=fs1|0|SKP236|47|348&s=1&b=NTU4\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"thinkstock\",\n" +
"          \"uri\": \"http://www.thinkstockphotos.com/image/stock-photo-king-penguin-creche/504247348\"\n" +
"        },\n" +
"        {\n" +
"          \"site_name\": \"istockphoto\",\n" +
"          \"uri\": \"http://www.istockphoto.com/photo/king-penguin-creche-gm504247348-83028141\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Pingüino cara blanca Guardería\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"614654754\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache1.asset-cache.net/xt/614654754.jpg?v=1&g=fs1|0|FKF|54|754&s=1&b=RjI4\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/photo/close-up-of-penguin-family-feeding-their-young-royalty-free-image/614654754\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Close up of Penguin family feeding their young\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"167450060\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache4.asset-cache.net/xt/167450060.jpg?v=1&g=fs1|0|NG|50|060&s=1&b=RTRE\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/photo/penguin-swims-at-the-surface-which-loads-high-res-stock-photography/167450060\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"A penguin swims at the surface, which loads its plumage with air.\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"167450113\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache3.asset-cache.net/xt/167450113.jpg?v=1&g=fs1|0|NG|50|113&s=1&b=RTRE\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/photo/penguins-swim-at-the-surface-which-loads-high-res-stock-photography/167450113\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Penguins swim at the surface, which loads their plumage with air.\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"510216928\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache3.asset-cache.net/xt/510216928.jpg?v=1&g=fs1|0|EPL|16|928&s=1&b=RjI4\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/photo/gentoo-penguin-in-water-royalty-free-image/510216928\"\n" +
"        },\n" +
"        {\n" +
"          \"site_name\": \"istockphoto\",\n" +
"          \"uri\": \"http://www.istockphoto.com/photo/gentoo-penguin-in-water-gm510216928-86155485\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Pingüino gentú en agua\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"538810833\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache4.asset-cache.net/xt/538810833.jpg?v=1&g=fs1|0|SKP282|10|833&s=1&b=NEY5\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"istockphoto\",\n" +
"          \"uri\": \"http://www.istockphoto.com/photo/emperor-penguin-isolated-on-white-background-with-clipping-path-gm538810833-58804582\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Pingüino emperador aislado sobre fondo blanco con trazado de recorte\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"513067423\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache4.asset-cache.net/xt/513067423.jpg?v=1&g=fs1|0|MNF|67|423&s=1&b=RjI4\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/photo/group-of-king-penguins-aptenodytes-patagonicus-on-royalty-free-image/513067423\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"A group of king penguins, Aptenodytes patagonicus on South Georgia Island.\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"186308897\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache1.asset-cache.net/xt/186308897.jpg?v=1&g=fs1|0|SKP155|08|897&s=1&b=RDhB\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"thinkstock\",\n" +
"          \"uri\": \"http://www.thinkstockphotos.com/image/stock-photo-gentoo-penguin-over-white-background/186308897\"\n" +
"        },\n" +
"        {\n" +
"          \"site_name\": \"istockphoto\",\n" +
"          \"uri\": \"http://www.istockphoto.com/photo/gentoo-penguin-over-white-background-gm186308897-27828280\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Pingüino gentú sobre fondo blanco\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"167450107\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache4.asset-cache.net/xt/167450107.jpg?v=1&g=fs1|0|NG|50|107&s=1&b=RTRE\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/photo/penguins-swim-at-the-surface-which-loads-high-res-stock-photography/167450107\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Penguins swim at the surface, which loads their plumage with air.\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"612558408\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache4.asset-cache.net/xt/612558408.jpg?v=1&g=fs1|0|FKF|58|408&s=1&b=RjI4\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/photo/close-up-of-baby-african-penguin-with-his-mother-royalty-free-image/612558408\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Close up of Baby african penguin with his mother\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": \"544501039\",\n" +
"      \"display_sizes\": [\n" +
"        {\n" +
"          \"is_watermarked\": false,\n" +
"          \"name\": \"thumb\",\n" +
"          \"uri\": \"http://cache4.asset-cache.net/xt/544501039.jpg?v=1&g=fs1|0|NG|01|039&s=1&b=RTRE\"\n" +
"        }\n" +
"      ],\n" +
"      \"referral_destinations\": [\n" +
"        {\n" +
"          \"site_name\": \"gettyimages\",\n" +
"          \"uri\": \"http://www.gettyimages.com/detail/photo/gentoo-penguins-jump-off-of-the-ice-into-high-res-stock-photography/544501039\"\n" +
"        }\n" +
"      ],\n" +
"      \"title\": \"Gentoo penguins jump off of the ice into the water near a cruise ship.\"\n" +
"    }\n" +
"  ]\n" +
"}";
    }
    
}
