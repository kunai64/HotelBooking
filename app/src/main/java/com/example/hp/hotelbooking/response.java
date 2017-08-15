package com.example.hp.hotelbooking;

import java.util.List;

/**
 * Created by kunai on 14/8/17.
 */

public class response {
    /**
     * html_attributions : []
     * result : {"address_components":[{"long_name":"48","short_name":"48","types":["street_number"]},{"long_name":"Pirrama Road","short_name":"Pirrama Rd","types":["route"]},{"long_name":"Pyrmont","short_name":"Pyrmont","types":["locality","political"]},{"long_name":"Council of the City of Sydney","short_name":"Sydney","types":["administrative_area_level_2","political"]},{"long_name":"New South Wales","short_name":"NSW","types":["administrative_area_level_1","political"]},{"long_name":"Australia","short_name":"AU","types":["country","political"]},{"long_name":"2009","short_name":"2009","types":["postal_code"]}],"adr_address":"<span class=\"street-address\">48 Pirrama Rd<\/span>, <span class=\"locality\">Pyrmont<\/span> <span class=\"region\">NSW<\/span> <span class=\"postal-code\">2009<\/span>, <span class=\"country-name\">Australia<\/span>","formatted_address":"48 Pirrama Rd, Pyrmont NSW 2009, Australia","formatted_phone_number":"(02) 9374 4000","geometry":{"location":{"lat":-33.8666199,"lng":151.1958527},"viewport":{"northeast":{"lat":-33.86537261970849,"lng":151.1969868302915},"southwest":{"lat":-33.86807058029149,"lng":151.1942888697085}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/generic_business-71.png","id":"4f89212bf76dde31f092cfc14d7506555d85b5c7","international_phone_number":"+61 2 9374 4000","name":"Google","opening_hours":{"open_now":false,"periods":[{"close":{"day":1,"time":"1800"},"open":{"day":1,"time":"1000"}},{"close":{"day":2,"time":"1800"},"open":{"day":2,"time":"1000"}},{"close":{"day":3,"time":"1800"},"open":{"day":3,"time":"1000"}},{"close":{"day":4,"time":"1800"},"open":{"day":4,"time":"1000"}},{"close":{"day":5,"time":"1800"},"open":{"day":5,"time":"1000"}}],"weekday_text":["Monday: 10:00 AM \u2013 6:00 PM","Tuesday: 10:00 AM \u2013 6:00 PM","Wednesday: 10:00 AM \u2013 6:00 PM","Thursday: 10:00 AM \u2013 6:00 PM","Friday: 10:00 AM \u2013 6:00 PM","Saturday: Closed","Sunday: Closed"]},"photos":[{"height":1536,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/113402266878939492174/photos\">Ranjan Ratnam<\/a>"],"photo_reference":"CmRaAAAAmUatQ4K37FXhc7z1RcqxNZ_psqWTNXU-PS7oQfjOa_m1D9-Qz7ug_POeHHbraBgcj3C7wOv6lS_kLTynVKnJeFfDOaG-m3E2_LB1Hhf-cyrvuCB11vwqZXymt3s6EXjEEhCmW5s1fxGucgqIBWggzbYIGhSjeKu2eFZJWtcM9j5Hk8-xxyHVVQ","width":2048},{"height":3024,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/101736177148133750997/photos\">William Feng<\/a>"],"photo_reference":"CmRaAAAAn6vlPPTLH75YSoHlIbJ8ozqF17tYqNnwzIQeUlQVzLEHRkBDE_yRvrLIsNivRSK1uvg1I_WrVPkp01QFryhieSZh1nBqpsL9t5qBNPAyovAOAOYtIFJvS6fya4lE1LhCEhAmiyRJ5hNYCb_IjbXhTzf6GhRuM1Mr4Owvv3QWJmsxn3s6C2RjhQ","width":4032},{"height":3024,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/115886271727815775491/photos\">Anthony Huynh<\/a>"],"photo_reference":"CmRaAAAAQdqg78ly6aD8gWEsdqT69X6tdwHjAJTwiaKYGH7RDe9Vlu04oQ5w0a7BFtGcCrPBK_Nw0tWO0rcs7UR5oRm3ebowDyi5uHbENqKSu6RLS6V6nfReMq625t3nEl5h93d1EhDWBqJTFWt34wMqIzqImkIxGhSAyUCp6xm4jK-UAw95C13F7U6Epw","width":4032},{"height":1184,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/106645265231048995466/photos\">Malik Ahamed<\/a>"],"photo_reference":"CmRaAAAADEvCMIihP73zRBLX9VNI8TAEDz5t2F9MK8Ns77xAQWkzhClN6aoMTiS0Qh0G0aFVa-Pvbyun1T6ug75negzzX-j10GQ5QxXImbIpEupPyHESHP-fZcYtk4CBgvbc7p55EhD5Z-n3MaqhLC1fa1F2jpxIGhT4eU4Izvy0i4Osec2znlapMECYtw","width":1776},{"height":1696,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/101909343152047003313/photos\">Kirill Tropin<\/a>"],"photo_reference":"CmRaAAAA1XCOKAQA_-iHNtBQ57rO_Z5nAAytlmquEjVhIbjO829YyK0pmh3nB4pP4zxhjTj_tTFIZTbpp-Xp1217Z8oMaSv7fziujm4kz1JvoCWTkLVV8Rg9Pq7iPlue9mBQDOXbEhC344JTbZ345WgOt6aCfUmyGhTqwKDRllt_m2zyoGDpftY0KayguQ","width":2864},{"height":2268,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/103668790976130239522/photos\">Muhammad Jadoon<\/a>"],"photo_reference":"CmRaAAAA4WrZMkoDaEGJx7Z9RcNcFia4EXU4Qtg8YQA41jxL_BJrCzRYLZXzbBfsEPgR4l4e0j8ye5z0q5DGKcr1lVj8JxjepLOcg2xrONGB7f6cArx7jZ1blJqj1hcS11OZckt7EhARzchcr-szIJ1ioR3iF6GhGhT_r1RWftyuugl7211ruut-Dx_0eA","width":4032},{"height":5582,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/110754641211532656340/photos\">Robert Koch<\/a>"],"photo_reference":"CmRaAAAAF7eKpK6UBL6UwhZEP5MypJioPTGhmDlOHU8w7PCZkDtK0JDztmQAkpT-itDss6AQ5HDXqp9G4j2PyCCPzsqlfFgFJGTa1OGkoSXQhr3A5WLM4P04QFd7pLdbQTRaNePUEhAU3kN36hVxpwW--wXleImCGhSn3HqnLrnyVeBnKU9YRVgra1yakw","width":2866},{"height":4032,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/102558609090086310801/photos\">Huy Tran<\/a>"],"photo_reference":"CmRaAAAA8l89_mhAdJ2dKbfU2PAmYVJuvty4EfySFZPyv4HEXSa1sy2ft6qSY8AcjcSrozGzBnKPGba4jnv-SI3-YDpxUKeXFAYnbdeMxZMGT1ae5gpQsgllCu4YJFg98LmQy6_zEhBIUxQlMC90i_mODfg-sJsGGhQU9SmmzUZS5BeltBgKm2wpakCF5Q","width":3024},{"height":3036,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/109685064423350865017/photos\">Martin Joller<\/a>"],"photo_reference":"CmRaAAAAraL0Mi360i-cImNl0JBihxRDFO_esVBaqH7Zozn8HHlEUxRcH_XYE2b0J9MW3oty7Y1eO_Na5JdBu2FbBC15T0W3BNIujDFu7OaMrUQRN5f_eEqZ4H1hSDTxbZsUgvfAEhC5LlKbPABZfZPzCukiz-H6GhQ1g4z_Q8CvkKztK_-U6HvcQ4iVqA","width":4048},{"height":2448,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/116976377324210679577/photos\">WH CHEN<\/a>"],"photo_reference":"CmRaAAAAkueJQ2XV7sVuwMtUTh8CW6tPQcamAa-hq5ot0VwyGJGpLKvuTNOQzI5Bw6ORanLMxJY10SUfwA2wli6Kfy85Zc4Ue78rxEyNDF1xk_-AkInZgnBvCpoxNlu2l8_z6z_uEhC7bqHUkRF0YjzENz-u9VqSGhSpknz5vHgAQwknHKT_jZD-nBdAYw","width":3264}],"place_id":"ChIJN1t_tDeuEmsRUsoyG83frY4","rating":4.4,"reference":"CmRSAAAAUrNx7-Dbxc3tUWRVepfxk02dI3-YJyQkLxcSor5BfRAlbpXmOIkKV8KYApUGVSd4Aj85Imek7tQe6Cr0jgFvHFgN8ZilrOW7TsmbVhdTRrWF_r3dggDf5fCOBvY8XiOGEhBRmC08wcXWtZHBJFWXXNkBGhQt23fSOg2gDToS5YdQV1EtX4VInw","reviews":[{"author_name":"Max Wong","author_url":"https://www.google.com/maps/contrib/103353900067375808343/reviews","language":"en","profile_photo_url":"https://lh5.googleusercontent.com/-mwKI6qFgi4U/AAAAAAAAAAI/AAAAAAAAAAA/AMp5VUqNjop-8plw74MoABh76vjljvGHIA/s128-c0x00000000-cc-rp-mo/photo.jpg","rating":2,"relative_time_description":"3 weeks ago","text":"With respect, I am a reviewer and reviewed two businesses with definite issues.  Unfortunately, google does not publish it (i suspect the owners object to my candid review). I could tell the businesses were using \"rent a crowd\" (first timer reviewers) to give it a five-star rating when I know the reputation is terrible. With poor reviews, it is up to business owner to have there right of reply as assert their views.  You can not censor what people write and when facts were presented (e.g. Court judgments in the form of website link).  It is a matter of public service.  I sincerely hope you that you will improve your service.  Wish you all the best!","time":1500521596},{"author_name":"Clint H","author_url":"https://www.google.com/maps/contrib/115831783227301411320/reviews","language":"en","profile_photo_url":"https://lh4.googleusercontent.com/-v-AfJ6Yd8AI/AAAAAAAAAAI/AAAAAAAAAAo/BNFgbYsj1no/s128-c0x00000000-cc-rp-mo/photo.jpg","rating":1,"relative_time_description":"2 weeks ago","text":"Apparently anyone can write whatever they want on your google business profile even when they are not your client and google won't do anything about it despite the review being in breach of their own policy regarding confidentiality. \nThrough a review written by a woman that is not even our customer, Google is allowing information that is confidential to our business and clients be made public, and Google refuses to fix the issue.","time":1501052618},{"author_name":"Mark Sales","author_url":"https://www.google.com/maps/contrib/100341567599258416785/reviews","language":"en","profile_photo_url":"https://lh6.googleusercontent.com/-e2bgb-ognDY/AAAAAAAAAAI/AAAAAAAAAAA/AMp5VUpbYR1liMi6kSIcjrQgFtbWODLE0Q/s128-c0x00000000-cc-rp-mo/photo.jpg","rating":1,"relative_time_description":"2 months ago","text":"You have to  FIX your Google MY BUSINESS page business.\nWhy the business owner CANNOT delete photos uploaded by anyone.\nI can delete the photos I uploaded but why is it so strange that anyone can upload and the owner of that page cannot delete the photos. I called the call centre and I have to explain IN DETAIL why i want to delete a photo!!!\nThats a total JOKE!!! its my page so i can do whatever I want!!!! So if the photo that a customer is legit and it was 10 years ago, i CANNOT delete that??? USELESS and TOTAL WASTE...","time":1496880715},{"author_name":"Sean Sellin","author_url":"https://www.google.com/maps/contrib/106336278434398788635/reviews","language":"en","profile_photo_url":"https://lh3.googleusercontent.com/-T99GiR3iN6Y/AAAAAAAAAAI/AAAAAAAAALA/BqTaGhptIfg/s128-c0x00000000-cc-rp-mo/photo.jpg","rating":1,"relative_time_description":"a month ago","text":"Very disappointed. I have been a supporter of Google and products 10 years now, I have used adwords in my business. We will stop using the products if things don't change. I have had a fake review on my site and sent multiple complaints to Google, however Google don't seem to care. This is a fake review by someone who has an alias for bad reviews. SEO businesses use google for bad reviews and give there business good reviews. Happened around the time we had issue with a bad web based business. Reviews are there to assist businesses better themselves and help consumers make a decision, but when its being abused by business to help them rank their paying customers not what it is intended for. Like most things online now you can comment without any repercussions.\nGoogle take a look at your products.","time":1499996109},{"author_name":"Michelle Lin","author_url":"https://www.google.com/maps/contrib/118229343712987820199/reviews","language":"en","profile_photo_url":"https://lh6.googleusercontent.com/-3-r1z_svAy4/AAAAAAAAAAI/AAAAAAAAAWI/kK8DGntVOq8/s128-c0x00000000-cc-rp-mo-ba5/photo.jpg","rating":5,"relative_time_description":"a month ago","text":"Really cool to visit. They have game rooms, scooters, free food/meals. Honestly, worth a visit if you can.","time":1499622799}],"scope":"GOOGLE","types":["point_of_interest","establishment"],"url":"https://maps.google.com/?cid=10281119596374313554","utc_offset":600,"vicinity":"48 Pirrama Road, Pyrmont","website":"https://www.google.com.au/about/careers/locations/sydney/"}
     * status : OK
     */

    private ResultBean result;
    private String status;
    private List<?> html_attributions;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<?> getHtml_attributions() {
        return html_attributions;
    }

    public void setHtml_attributions(List<?> html_attributions) {
        this.html_attributions = html_attributions;
    }

    public static class ResultBean {
        /**
         * address_components : [{"long_name":"48","short_name":"48","types":["street_number"]},{"long_name":"Pirrama Road","short_name":"Pirrama Rd","types":["route"]},{"long_name":"Pyrmont","short_name":"Pyrmont","types":["locality","political"]},{"long_name":"Council of the City of Sydney","short_name":"Sydney","types":["administrative_area_level_2","political"]},{"long_name":"New South Wales","short_name":"NSW","types":["administrative_area_level_1","political"]},{"long_name":"Australia","short_name":"AU","types":["country","political"]},{"long_name":"2009","short_name":"2009","types":["postal_code"]}]
         * adr_address : <span class="street-address">48 Pirrama Rd</span>, <span class="locality">Pyrmont</span> <span class="region">NSW</span> <span class="postal-code">2009</span>, <span class="country-name">Australia</span>
         * formatted_address : 48 Pirrama Rd, Pyrmont NSW 2009, Australia
         * formatted_phone_number : (02) 9374 4000
         * geometry : {"location":{"lat":-33.8666199,"lng":151.1958527},"viewport":{"northeast":{"lat":-33.86537261970849,"lng":151.1969868302915},"southwest":{"lat":-33.86807058029149,"lng":151.1942888697085}}}
         * icon : https://maps.gstatic.com/mapfiles/place_api/icons/generic_business-71.png
         * id : 4f89212bf76dde31f092cfc14d7506555d85b5c7
         * international_phone_number : +61 2 9374 4000
         * name : Google
         * opening_hours : {"open_now":false,"periods":[{"close":{"day":1,"time":"1800"},"open":{"day":1,"time":"1000"}},{"close":{"day":2,"time":"1800"},"open":{"day":2,"time":"1000"}},{"close":{"day":3,"time":"1800"},"open":{"day":3,"time":"1000"}},{"close":{"day":4,"time":"1800"},"open":{"day":4,"time":"1000"}},{"close":{"day":5,"time":"1800"},"open":{"day":5,"time":"1000"}}],"weekday_text":["Monday: 10:00 AM \u2013 6:00 PM","Tuesday: 10:00 AM \u2013 6:00 PM","Wednesday: 10:00 AM \u2013 6:00 PM","Thursday: 10:00 AM \u2013 6:00 PM","Friday: 10:00 AM \u2013 6:00 PM","Saturday: Closed","Sunday: Closed"]}
         * photos : [{"height":1536,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/113402266878939492174/photos\">Ranjan Ratnam<\/a>"],"photo_reference":"CmRaAAAAmUatQ4K37FXhc7z1RcqxNZ_psqWTNXU-PS7oQfjOa_m1D9-Qz7ug_POeHHbraBgcj3C7wOv6lS_kLTynVKnJeFfDOaG-m3E2_LB1Hhf-cyrvuCB11vwqZXymt3s6EXjEEhCmW5s1fxGucgqIBWggzbYIGhSjeKu2eFZJWtcM9j5Hk8-xxyHVVQ","width":2048},{"height":3024,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/101736177148133750997/photos\">William Feng<\/a>"],"photo_reference":"CmRaAAAAn6vlPPTLH75YSoHlIbJ8ozqF17tYqNnwzIQeUlQVzLEHRkBDE_yRvrLIsNivRSK1uvg1I_WrVPkp01QFryhieSZh1nBqpsL9t5qBNPAyovAOAOYtIFJvS6fya4lE1LhCEhAmiyRJ5hNYCb_IjbXhTzf6GhRuM1Mr4Owvv3QWJmsxn3s6C2RjhQ","width":4032},{"height":3024,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/115886271727815775491/photos\">Anthony Huynh<\/a>"],"photo_reference":"CmRaAAAAQdqg78ly6aD8gWEsdqT69X6tdwHjAJTwiaKYGH7RDe9Vlu04oQ5w0a7BFtGcCrPBK_Nw0tWO0rcs7UR5oRm3ebowDyi5uHbENqKSu6RLS6V6nfReMq625t3nEl5h93d1EhDWBqJTFWt34wMqIzqImkIxGhSAyUCp6xm4jK-UAw95C13F7U6Epw","width":4032},{"height":1184,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/106645265231048995466/photos\">Malik Ahamed<\/a>"],"photo_reference":"CmRaAAAADEvCMIihP73zRBLX9VNI8TAEDz5t2F9MK8Ns77xAQWkzhClN6aoMTiS0Qh0G0aFVa-Pvbyun1T6ug75negzzX-j10GQ5QxXImbIpEupPyHESHP-fZcYtk4CBgvbc7p55EhD5Z-n3MaqhLC1fa1F2jpxIGhT4eU4Izvy0i4Osec2znlapMECYtw","width":1776},{"height":1696,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/101909343152047003313/photos\">Kirill Tropin<\/a>"],"photo_reference":"CmRaAAAA1XCOKAQA_-iHNtBQ57rO_Z5nAAytlmquEjVhIbjO829YyK0pmh3nB4pP4zxhjTj_tTFIZTbpp-Xp1217Z8oMaSv7fziujm4kz1JvoCWTkLVV8Rg9Pq7iPlue9mBQDOXbEhC344JTbZ345WgOt6aCfUmyGhTqwKDRllt_m2zyoGDpftY0KayguQ","width":2864},{"height":2268,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/103668790976130239522/photos\">Muhammad Jadoon<\/a>"],"photo_reference":"CmRaAAAA4WrZMkoDaEGJx7Z9RcNcFia4EXU4Qtg8YQA41jxL_BJrCzRYLZXzbBfsEPgR4l4e0j8ye5z0q5DGKcr1lVj8JxjepLOcg2xrONGB7f6cArx7jZ1blJqj1hcS11OZckt7EhARzchcr-szIJ1ioR3iF6GhGhT_r1RWftyuugl7211ruut-Dx_0eA","width":4032},{"height":5582,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/110754641211532656340/photos\">Robert Koch<\/a>"],"photo_reference":"CmRaAAAAF7eKpK6UBL6UwhZEP5MypJioPTGhmDlOHU8w7PCZkDtK0JDztmQAkpT-itDss6AQ5HDXqp9G4j2PyCCPzsqlfFgFJGTa1OGkoSXQhr3A5WLM4P04QFd7pLdbQTRaNePUEhAU3kN36hVxpwW--wXleImCGhSn3HqnLrnyVeBnKU9YRVgra1yakw","width":2866},{"height":4032,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/102558609090086310801/photos\">Huy Tran<\/a>"],"photo_reference":"CmRaAAAA8l89_mhAdJ2dKbfU2PAmYVJuvty4EfySFZPyv4HEXSa1sy2ft6qSY8AcjcSrozGzBnKPGba4jnv-SI3-YDpxUKeXFAYnbdeMxZMGT1ae5gpQsgllCu4YJFg98LmQy6_zEhBIUxQlMC90i_mODfg-sJsGGhQU9SmmzUZS5BeltBgKm2wpakCF5Q","width":3024},{"height":3036,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/109685064423350865017/photos\">Martin Joller<\/a>"],"photo_reference":"CmRaAAAAraL0Mi360i-cImNl0JBihxRDFO_esVBaqH7Zozn8HHlEUxRcH_XYE2b0J9MW3oty7Y1eO_Na5JdBu2FbBC15T0W3BNIujDFu7OaMrUQRN5f_eEqZ4H1hSDTxbZsUgvfAEhC5LlKbPABZfZPzCukiz-H6GhQ1g4z_Q8CvkKztK_-U6HvcQ4iVqA","width":4048},{"height":2448,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/116976377324210679577/photos\">WH CHEN<\/a>"],"photo_reference":"CmRaAAAAkueJQ2XV7sVuwMtUTh8CW6tPQcamAa-hq5ot0VwyGJGpLKvuTNOQzI5Bw6ORanLMxJY10SUfwA2wli6Kfy85Zc4Ue78rxEyNDF1xk_-AkInZgnBvCpoxNlu2l8_z6z_uEhC7bqHUkRF0YjzENz-u9VqSGhSpknz5vHgAQwknHKT_jZD-nBdAYw","width":3264}]
         * place_id : ChIJN1t_tDeuEmsRUsoyG83frY4
         * rating : 4.4
         * reference : CmRSAAAAUrNx7-Dbxc3tUWRVepfxk02dI3-YJyQkLxcSor5BfRAlbpXmOIkKV8KYApUGVSd4Aj85Imek7tQe6Cr0jgFvHFgN8ZilrOW7TsmbVhdTRrWF_r3dggDf5fCOBvY8XiOGEhBRmC08wcXWtZHBJFWXXNkBGhQt23fSOg2gDToS5YdQV1EtX4VInw
         * reviews : [{"author_name":"Max Wong","author_url":"https://www.google.com/maps/contrib/103353900067375808343/reviews","language":"en","profile_photo_url":"https://lh5.googleusercontent.com/-mwKI6qFgi4U/AAAAAAAAAAI/AAAAAAAAAAA/AMp5VUqNjop-8plw74MoABh76vjljvGHIA/s128-c0x00000000-cc-rp-mo/photo.jpg","rating":2,"relative_time_description":"3 weeks ago","text":"With respect, I am a reviewer and reviewed two businesses with definite issues.  Unfortunately, google does not publish it (i suspect the owners object to my candid review). I could tell the businesses were using \"rent a crowd\" (first timer reviewers) to give it a five-star rating when I know the reputation is terrible. With poor reviews, it is up to business owner to have there right of reply as assert their views.  You can not censor what people write and when facts were presented (e.g. Court judgments in the form of website link).  It is a matter of public service.  I sincerely hope you that you will improve your service.  Wish you all the best!","time":1500521596},{"author_name":"Clint H","author_url":"https://www.google.com/maps/contrib/115831783227301411320/reviews","language":"en","profile_photo_url":"https://lh4.googleusercontent.com/-v-AfJ6Yd8AI/AAAAAAAAAAI/AAAAAAAAAAo/BNFgbYsj1no/s128-c0x00000000-cc-rp-mo/photo.jpg","rating":1,"relative_time_description":"2 weeks ago","text":"Apparently anyone can write whatever they want on your google business profile even when they are not your client and google won't do anything about it despite the review being in breach of their own policy regarding confidentiality. \nThrough a review written by a woman that is not even our customer, Google is allowing information that is confidential to our business and clients be made public, and Google refuses to fix the issue.","time":1501052618},{"author_name":"Mark Sales","author_url":"https://www.google.com/maps/contrib/100341567599258416785/reviews","language":"en","profile_photo_url":"https://lh6.googleusercontent.com/-e2bgb-ognDY/AAAAAAAAAAI/AAAAAAAAAAA/AMp5VUpbYR1liMi6kSIcjrQgFtbWODLE0Q/s128-c0x00000000-cc-rp-mo/photo.jpg","rating":1,"relative_time_description":"2 months ago","text":"You have to  FIX your Google MY BUSINESS page business.\nWhy the business owner CANNOT delete photos uploaded by anyone.\nI can delete the photos I uploaded but why is it so strange that anyone can upload and the owner of that page cannot delete the photos. I called the call centre and I have to explain IN DETAIL why i want to delete a photo!!!\nThats a total JOKE!!! its my page so i can do whatever I want!!!! So if the photo that a customer is legit and it was 10 years ago, i CANNOT delete that??? USELESS and TOTAL WASTE...","time":1496880715},{"author_name":"Sean Sellin","author_url":"https://www.google.com/maps/contrib/106336278434398788635/reviews","language":"en","profile_photo_url":"https://lh3.googleusercontent.com/-T99GiR3iN6Y/AAAAAAAAAAI/AAAAAAAAALA/BqTaGhptIfg/s128-c0x00000000-cc-rp-mo/photo.jpg","rating":1,"relative_time_description":"a month ago","text":"Very disappointed. I have been a supporter of Google and products 10 years now, I have used adwords in my business. We will stop using the products if things don't change. I have had a fake review on my site and sent multiple complaints to Google, however Google don't seem to care. This is a fake review by someone who has an alias for bad reviews. SEO businesses use google for bad reviews and give there business good reviews. Happened around the time we had issue with a bad web based business. Reviews are there to assist businesses better themselves and help consumers make a decision, but when its being abused by business to help them rank their paying customers not what it is intended for. Like most things online now you can comment without any repercussions.\nGoogle take a look at your products.","time":1499996109},{"author_name":"Michelle Lin","author_url":"https://www.google.com/maps/contrib/118229343712987820199/reviews","language":"en","profile_photo_url":"https://lh6.googleusercontent.com/-3-r1z_svAy4/AAAAAAAAAAI/AAAAAAAAAWI/kK8DGntVOq8/s128-c0x00000000-cc-rp-mo-ba5/photo.jpg","rating":5,"relative_time_description":"a month ago","text":"Really cool to visit. They have game rooms, scooters, free food/meals. Honestly, worth a visit if you can.","time":1499622799}]
         * scope : GOOGLE
         * types : ["point_of_interest","establishment"]
         * url : https://maps.google.com/?cid=10281119596374313554
         * utc_offset : 600
         * vicinity : 48 Pirrama Road, Pyrmont
         * website : https://www.google.com.au/about/careers/locations/sydney/
         */

        private String adr_address;
        private String formatted_address;
        private String formatted_phone_number;
        private GeometryBean geometry;
        private String icon;
        private String id;
        private String international_phone_number;
        private String name;
        private OpeningHoursBean opening_hours;
        private String place_id;
        private double rating;
        private String reference;
        private String scope;
        private String url;
        private int utc_offset;
        private String vicinity;
        private String website;
        private List<AddressComponentsBean> address_components;
        private List<PhotosBean> photos;
        private List<ReviewsBean> reviews;
        private List<String> types;

        public String getAdr_address() {
            return adr_address;
        }

        public void setAdr_address(String adr_address) {
            this.adr_address = adr_address;
        }

        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public String getFormatted_phone_number() {
            return formatted_phone_number;
        }

        public void setFormatted_phone_number(String formatted_phone_number) {
            this.formatted_phone_number = formatted_phone_number;
        }

        public GeometryBean getGeometry() {
            return geometry;
        }

        public void setGeometry(GeometryBean geometry) {
            this.geometry = geometry;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getInternational_phone_number() {
            return international_phone_number;
        }

        public void setInternational_phone_number(String international_phone_number) {
            this.international_phone_number = international_phone_number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public OpeningHoursBean getOpening_hours() {
            return opening_hours;
        }

        public void setOpening_hours(OpeningHoursBean opening_hours) {
            this.opening_hours = opening_hours;
        }

        public String getPlace_id() {
            return place_id;
        }

        public void setPlace_id(String place_id) {
            this.place_id = place_id;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getUtc_offset() {
            return utc_offset;
        }

        public void setUtc_offset(int utc_offset) {
            this.utc_offset = utc_offset;
        }

        public String getVicinity() {
            return vicinity;
        }

        public void setVicinity(String vicinity) {
            this.vicinity = vicinity;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public List<AddressComponentsBean> getAddress_components() {
            return address_components;
        }

        public void setAddress_components(List<AddressComponentsBean> address_components) {
            this.address_components = address_components;
        }

        public List<PhotosBean> getPhotos() {
            return photos;
        }

        public void setPhotos(List<PhotosBean> photos) {
            this.photos = photos;
        }

        public List<ReviewsBean> getReviews() {
            return reviews;
        }

        public void setReviews(List<ReviewsBean> reviews) {
            this.reviews = reviews;
        }

        public List<String> getTypes() {
            return types;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }

        public static class GeometryBean {
            /**
             * location : {"lat":-33.8666199,"lng":151.1958527}
             * viewport : {"northeast":{"lat":-33.86537261970849,"lng":151.1969868302915},"southwest":{"lat":-33.86807058029149,"lng":151.1942888697085}}
             */

            private LocationBean location;
            private ViewportBean viewport;

            public LocationBean getLocation() {
                return location;
            }

            public void setLocation(LocationBean location) {
                this.location = location;
            }

            public ViewportBean getViewport() {
                return viewport;
            }

            public void setViewport(ViewportBean viewport) {
                this.viewport = viewport;
            }

            public static class LocationBean {
                /**
                 * lat : -33.8666199
                 * lng : 151.1958527
                 */

                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }

            public static class ViewportBean {
                /**
                 * northeast : {"lat":-33.86537261970849,"lng":151.1969868302915}
                 * southwest : {"lat":-33.86807058029149,"lng":151.1942888697085}
                 */

                private NortheastBean northeast;
                private SouthwestBean southwest;

                public NortheastBean getNortheast() {
                    return northeast;
                }

                public void setNortheast(NortheastBean northeast) {
                    this.northeast = northeast;
                }

                public SouthwestBean getSouthwest() {
                    return southwest;
                }

                public void setSouthwest(SouthwestBean southwest) {
                    this.southwest = southwest;
                }

                public static class NortheastBean {
                    /**
                     * lat : -33.86537261970849
                     * lng : 151.1969868302915
                     */

                    private double lat;
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }

                public static class SouthwestBean {
                    /**
                     * lat : -33.86807058029149
                     * lng : 151.1942888697085
                     */

                    private double lat;
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }
            }
        }

        public static class OpeningHoursBean {
            /**
             * open_now : false
             * periods : [{"close":{"day":1,"time":"1800"},"open":{"day":1,"time":"1000"}},{"close":{"day":2,"time":"1800"},"open":{"day":2,"time":"1000"}},{"close":{"day":3,"time":"1800"},"open":{"day":3,"time":"1000"}},{"close":{"day":4,"time":"1800"},"open":{"day":4,"time":"1000"}},{"close":{"day":5,"time":"1800"},"open":{"day":5,"time":"1000"}}]
             * weekday_text : ["Monday: 10:00 AM \u2013 6:00 PM","Tuesday: 10:00 AM \u2013 6:00 PM","Wednesday: 10:00 AM \u2013 6:00 PM","Thursday: 10:00 AM \u2013 6:00 PM","Friday: 10:00 AM \u2013 6:00 PM","Saturday: Closed","Sunday: Closed"]
             */

            private boolean open_now;
            private List<PeriodsBean> periods;
            private List<String> weekday_text;

            public boolean isOpen_now() {
                return open_now;
            }

            public void setOpen_now(boolean open_now) {
                this.open_now = open_now;
            }

            public List<PeriodsBean> getPeriods() {
                return periods;
            }

            public void setPeriods(List<PeriodsBean> periods) {
                this.periods = periods;
            }

            public List<String> getWeekday_text() {
                return weekday_text;
            }

            public void setWeekday_text(List<String> weekday_text) {
                this.weekday_text = weekday_text;
            }

            public static class PeriodsBean {
                /**
                 * close : {"day":1,"time":"1800"}
                 * open : {"day":1,"time":"1000"}
                 */

                private CloseBean close;
                private OpenBean open;

                public CloseBean getClose() {
                    return close;
                }

                public void setClose(CloseBean close) {
                    this.close = close;
                }

                public OpenBean getOpen() {
                    return open;
                }

                public void setOpen(OpenBean open) {
                    this.open = open;
                }

                public static class CloseBean {
                    /**
                     * day : 1
                     * time : 1800
                     */

                    private int day;
                    private String time;

                    public int getDay() {
                        return day;
                    }

                    public void setDay(int day) {
                        this.day = day;
                    }

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }
                }

                public static class OpenBean {
                    /**
                     * day : 1
                     * time : 1000
                     */

                    private int day;
                    private String time;

                    public int getDay() {
                        return day;
                    }

                    public void setDay(int day) {
                        this.day = day;
                    }

                    public String getTime() {
                        return time;
                    }

                    public void setTime(String time) {
                        this.time = time;
                    }
                }
            }
        }

        public static class AddressComponentsBean {
            /**
             * long_name : 48
             * short_name : 48
             * types : ["street_number"]
             */

            private String long_name;
            private String short_name;
            private List<String> types;

            public String getLong_name() {
                return long_name;
            }

            public void setLong_name(String long_name) {
                this.long_name = long_name;
            }

            public String getShort_name() {
                return short_name;
            }

            public void setShort_name(String short_name) {
                this.short_name = short_name;
            }

            public List<String> getTypes() {
                return types;
            }

            public void setTypes(List<String> types) {
                this.types = types;
            }
        }

        public static class PhotosBean {
            /**
             * height : 1536
             * html_attributions : ["<a href=\"https://maps.google.com/maps/contrib/113402266878939492174/photos\">Ranjan Ratnam<\/a>"]
             * photo_reference : CmRaAAAAmUatQ4K37FXhc7z1RcqxNZ_psqWTNXU-PS7oQfjOa_m1D9-Qz7ug_POeHHbraBgcj3C7wOv6lS_kLTynVKnJeFfDOaG-m3E2_LB1Hhf-cyrvuCB11vwqZXymt3s6EXjEEhCmW5s1fxGucgqIBWggzbYIGhSjeKu2eFZJWtcM9j5Hk8-xxyHVVQ
             * width : 2048
             */

            private int height;
            private String photo_reference;
            private int width;
            private List<String> html_attributions;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getPhoto_reference() {
                return photo_reference;
            }

            public void setPhoto_reference(String photo_reference) {
                this.photo_reference = photo_reference;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public List<String> getHtml_attributions() {
                return html_attributions;
            }

            public void setHtml_attributions(List<String> html_attributions) {
                this.html_attributions = html_attributions;
            }
        }

        public static class ReviewsBean {
            /**
             * author_name : Max Wong
             * author_url : https://www.google.com/maps/contrib/103353900067375808343/reviews
             * language : en
             * profile_photo_url : https://lh5.googleusercontent.com/-mwKI6qFgi4U/AAAAAAAAAAI/AAAAAAAAAAA/AMp5VUqNjop-8plw74MoABh76vjljvGHIA/s128-c0x00000000-cc-rp-mo/photo.jpg
             * rating : 2
             * relative_time_description : 3 weeks ago
             * text : With respect, I am a reviewer and reviewed two businesses with definite issues.  Unfortunately, google does not publish it (i suspect the owners object to my candid review). I could tell the businesses were using "rent a crowd" (first timer reviewers) to give it a five-star rating when I know the reputation is terrible. With poor reviews, it is up to business owner to have there right of reply as assert their views.  You can not censor what people write and when facts were presented (e.g. Court judgments in the form of website link).  It is a matter of public service.  I sincerely hope you that you will improve your service.  Wish you all the best!
             * time : 1500521596
             */

            private String author_name;
            private String author_url;
            private String language;
            private String profile_photo_url;
            private int rating;
            private String relative_time_description;
            private String text;
            private int time;

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getAuthor_url() {
                return author_url;
            }

            public void setAuthor_url(String author_url) {
                this.author_url = author_url;
            }

            public String getLanguage() {
                return language;
            }

            public void setLanguage(String language) {
                this.language = language;
            }

            public String getProfile_photo_url() {
                return profile_photo_url;
            }

            public void setProfile_photo_url(String profile_photo_url) {
                this.profile_photo_url = profile_photo_url;
            }

            public int getRating() {
                return rating;
            }

            public void setRating(int rating) {
                this.rating = rating;
            }

            public String getRelative_time_description() {
                return relative_time_description;
            }

            public void setRelative_time_description(String relative_time_description) {
                this.relative_time_description = relative_time_description;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }
        }
    }
}
