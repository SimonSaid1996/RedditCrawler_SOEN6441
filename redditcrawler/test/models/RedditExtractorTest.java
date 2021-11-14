package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests the all functions in the RedditExtractor
 * @author Ziran Cao
 * @version v1
 */
class RedditExtractorTest {
    /**
     * test how to get latest 10 reddit search results asynchronously
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getLatestSubmissions() {
        User us = new User();
        RedditExtractor re = new RedditExtractor(us);
        assertNotNull(re.getLatestSubmissions("weather"));
    }
    /**
     * test how to get api results
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getApiResults() {
        String api = "https://api.pushshift.io/reddit/search/submission/?q=weather&size=10";
        RedditExtractor re = new RedditExtractor();
        assertNotNull(re.getApiResults(api));
    }
    /**
     * test how to parse
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void parse() {

        RedditExtractor re = new RedditExtractor();
        String test = "{\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"all_awardings\": [],\n" +
                "            \"allow_live_comments\": false,\n" +
                "            \"author\": \"Kay76\",\n" +
                "            \"author_flair_css_class\": null,\n" +
                "            \"author_flair_richtext\": [],\n" +
                "            \"author_flair_text\": null,\n" +
                "            \"author_flair_type\": \"text\",\n" +
                "            \"author_fullname\": \"t2_b0xcbw7\",\n" +
                "            \"author_is_blocked\": false,\n" +
                "            \"author_patreon_flair\": false,\n" +
                "            \"author_premium\": false,\n" +
                "            \"awarders\": [],\n" +
                "            \"can_mod_post\": false,\n" +
                "            \"contest_mode\": false,\n" +
                "            \"created_utc\": 1636906322,\n" +
                "            \"domain\": \"self.antiwork\",\n" +
                "            \"full_link\": \"https://www.reddit.com/r/antiwork/comments/qtt1dd/yahoo_the_great_resignation_how_to_financially/\",\n" +
                "            \"gildings\": {},\n" +
                "            \"id\": \"qtt1dd\",\n" +
                "            \"is_created_from_ads_ui\": false,\n" +
                "            \"is_crosspostable\": true,\n" +
                "            \"is_meta\": false,\n" +
                "            \"is_original_content\": false,\n" +
                "            \"is_reddit_media_domain\": false,\n" +
                "            \"is_robot_indexable\": true,\n" +
                "            \"is_self\": true,\n" +
                "            \"is_video\": false,\n" +
                "            \"link_flair_background_color\": \"\",\n" +
                "            \"link_flair_richtext\": [],\n" +
                "            \"link_flair_text_color\": \"dark\",\n" +
                "            \"link_flair_type\": \"text\",\n" +
                "            \"locked\": false,\n" +
                "            \"media_only\": false,\n" +
                "            \"no_follow\": false,\n" +
                "            \"num_comments\": 0,\n" +
                "            \"num_crossposts\": 0,\n" +
                "            \"over_18\": false,\n" +
                "            \"parent_whitelist_status\": \"all_ads\",\n" +
                "            \"permalink\": \"/r/antiwork/comments/qtt1dd/yahoo_the_great_resignation_how_to_financially/\",\n" +
                "            \"pinned\": false,\n" +
                "            \"pwls\": 6,\n" +
                "            \"retrieved_on\": 1636906333,\n" +
                "            \"score\": 1,\n" +
                "            \"selftext\": \"This was on the main page of Yahoo this morning, I don't even remember why I loaded Yahoo now.  This is just another point of not understanding what is really going on.  First big thing that stuck out - 24 months of income before you should quit?  WHY DO YOU THINK PEOPLE ARE QUITTING YOU IDIOTS!!!  This is like the financial groups telling you how to budget on a minimum wage job, they have no clue what it really costs to LIVE.  Not thrive, not have what our parents and grandparents had, just barely live.  Maybe borrow against your retirement or a line of credit to get you through the between jobs.  Why the hell would you do that, people are finding new jobs to get OUT of debt.  WTF,  WHY DO YOU THINK PEOPLE ARE QUITTING YOU IDIOTS!!!  Think on how this might extend your working years?  Again, WHY DO YOU THINK PEOPLE ARE QUITTING YOU IDIOTS!!!\",\n" +
                "            \"send_replies\": true,\n" +
                "            \"spoiler\": false,\n" +
                "            \"stickied\": false,\n" +
                "            \"subreddit\": \"antiwork\",\n" +
                "            \"subreddit_id\": \"t5_2y77d\",\n" +
                "            \"subreddit_subscribers\": 1066874,\n" +
                "            \"subreddit_type\": \"public\",\n" +
                "            \"suggested_sort\": \"confidence\",\n" +
                "            \"thumbnail\": \"self\",\n" +
                "            \"title\": \"YAHOO - The Great Resignation: How to financially prepare to quit your job\",\n" +
                "            \"total_awards_received\": 0,\n" +
                "            \"treatment_tags\": [],\n" +
                "            \"upvote_ratio\": 1.0,\n" +
                "            \"url\": \"https://www.reddit.com/r/antiwork/comments/qtt1dd/yahoo_the_great_resignation_how_to_financially/\",\n" +
                "            \"whitelist_status\": \"all_ads\",\n" +
                "            \"wls\": 6\n" +
                "        },\n" +
                "        {\n" +
                "            \"all_awardings\": [],\n" +
                "            \"allow_live_comments\": false,\n" +
                "            \"author\": \"gavinflo25\",\n" +
                "            \"author_flair_css_class\": null,\n" +
                "            \"author_flair_richtext\": [],\n" +
                "            \"author_flair_text\": null,\n" +
                "            \"author_flair_type\": \"text\",\n" +
                "            \"author_fullname\": \"t2_2tjjlt1q\",\n" +
                "            \"author_is_blocked\": false,\n" +
                "            \"author_patreon_flair\": false,\n" +
                "            \"author_premium\": true,\n" +
                "            \"awarders\": [],\n" +
                "            \"can_mod_post\": false,\n" +
                "            \"contest_mode\": false,\n" +
                "            \"created_utc\": 1636906321,\n" +
                "            \"domain\": \"i.redd.it\",\n" +
                "            \"full_link\": \"https://www.reddit.com/r/SatoshiStreetBets/comments/qtt1d0/pitbull_token_126m_market_cap_65m_liq_burned/\",\n" +
                "            \"gildings\": {},\n" +
                "            \"id\": \"qtt1d0\",\n" +
                "            \"is_created_from_ads_ui\": false,\n" +
                "            \"is_crosspostable\": true,\n" +
                "            \"is_meta\": false,\n" +
                "            \"is_original_content\": false,\n" +
                "            \"is_reddit_media_domain\": true,\n" +
                "            \"is_robot_indexable\": true,\n" +
                "            \"is_self\": false,\n" +
                "            \"is_video\": false,\n" +
                "            \"link_flair_background_color\": \"#0079d3\",\n" +
                "            \"link_flair_richtext\": [\n" +
                "                {\n" +
                "                    \"e\": \"text\",\n" +
                "                    \"t\": \"News \\ud83d\\udcf0\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"link_flair_template_id\": \"f2bc0760-546b-11eb-be41-0e7abfd8f0f5\",\n" +
                "            \"link_flair_text\": \"News \\ud83d\\udcf0\",\n" +
                "            \"link_flair_text_color\": \"light\",\n" +
                "            \"link_flair_type\": \"richtext\",\n" +
                "            \"locked\": false,\n" +
                "            \"media_only\": false,\n" +
                "            \"no_follow\": true,\n" +
                "            \"num_comments\": 0,\n" +
                "            \"num_crossposts\": 0,\n" +
                "            \"over_18\": false,\n" +
                "            \"parent_whitelist_status\": \"no_ads\",\n" +
                "            \"permalink\": \"/r/SatoshiStreetBets/comments/qtt1d0/pitbull_token_126m_market_cap_65m_liq_burned/\",\n" +
                "            \"pinned\": false,\n" +
                "            \"post_hint\": \"image\",\n" +
                "            \"preview\": {\n" +
                "                \"enabled\": true,\n" +
                "                \"images\": [\n" +
                "                    {\n" +
                "                        \"id\": \"r_Vn_ykOgNql1O0Q0gPPuVqcO75T4F_DrLwEa6_auac\",\n" +
                "                        \"resolutions\": [\n" +
                "                            {\n" +
                "                                \"height\": 58,\n" +
                "                                \"url\": \"https://preview.redd.it/a9yivus85lz71.png?width=108&amp;crop=smart&amp;auto=webp&amp;s=bdb42baeae07520ffee22f6f74fefd205db1149e\",\n" +
                "                                \"width\": 108\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 117,\n" +
                "                                \"url\": \"https://preview.redd.it/a9yivus85lz71.png?width=216&amp;crop=smart&amp;auto=webp&amp;s=ef18d6208411fc04c0690395a38140e3ceb293e9\",\n" +
                "                                \"width\": 216\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 174,\n" +
                "                                \"url\": \"https://preview.redd.it/a9yivus85lz71.png?width=320&amp;crop=smart&amp;auto=webp&amp;s=482a0dc94bdf610da7e56097068475ffe9e8b927\",\n" +
                "                                \"width\": 320\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 349,\n" +
                "                                \"url\": \"https://preview.redd.it/a9yivus85lz71.png?width=640&amp;crop=smart&amp;auto=webp&amp;s=7b02f5ddc903226eaa6b7dcef3edc9fa20e4c5c7\",\n" +
                "                                \"width\": 640\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 523,\n" +
                "                                \"url\": \"https://preview.redd.it/a9yivus85lz71.png?width=960&amp;crop=smart&amp;auto=webp&amp;s=71c036e031856ac7d5cc8d9341c24b7620ed06e0\",\n" +
                "                                \"width\": 960\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 589,\n" +
                "                                \"url\": \"https://preview.redd.it/a9yivus85lz71.png?width=1080&amp;crop=smart&amp;auto=webp&amp;s=e147395d2d4e925cff7d2e8526d40f0b7d29ce5d\",\n" +
                "                                \"width\": 1080\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"source\": {\n" +
                "                            \"height\": 1046,\n" +
                "                            \"url\": \"https://preview.redd.it/a9yivus85lz71.png?auto=webp&amp;s=87a5ca4e2f66cade4d3d5210626a1077b37aac4d\",\n" +
                "                            \"width\": 1917\n" +
                "                        },\n" +
                "                        \"variants\": {}\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            \"pwls\": 0,\n" +
                "            \"retrieved_on\": 1636906331,\n" +
                "            \"score\": 1,\n" +
                "            \"selftext\": \"\",\n" +
                "            \"send_replies\": true,\n" +
                "            \"spoiler\": false,\n" +
                "            \"stickied\": false,\n" +
                "            \"subreddit\": \"SatoshiStreetBets\",\n" +
                "            \"subreddit_id\": \"t5_2g4vgd\",\n" +
                "            \"subreddit_subscribers\": 503774,\n" +
                "            \"subreddit_type\": \"public\",\n" +
                "            \"thumbnail\": \"https://b.thumbs.redditmedia.com/Mp5n_vgtLB1dA7DzVsChM45zOzsRIdYCx1feAudwNbs.jpg\",\n" +
                "            \"thumbnail_height\": 76,\n" +
                "            \"thumbnail_width\": 140,\n" +
                "            \"title\": \"\\ud83d\\udc36Pitbull Token | 126M Market Cap - 6.5M$ Liq burned forever | Listed on Mexc Global and Bkex in last 2 days - Futures trading on Mexc | Major Donation Program featured on Yahoo finance - partnered with Voohees Animal | 58.7% Tokens burnt | 341K Holders - increasing daily| \\ud83d\\udea8P2E and MetaVerse coming\",\n" +
                "            \"total_awards_received\": 0,\n" +
                "            \"treatment_tags\": [],\n" +
                "            \"upvote_ratio\": 1.0,\n" +
                "            \"url\": \"https://i.redd.it/a9yivus85lz71.png\",\n" +
                "            \"url_overridden_by_dest\": \"https://i.redd.it/a9yivus85lz71.png\",\n" +
                "            \"whitelist_status\": \"no_ads\",\n" +
                "            \"wls\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"all_awardings\": [],\n" +
                "            \"allow_live_comments\": false,\n" +
                "            \"author\": \"gavinflo25\",\n" +
                "            \"author_flair_css_class\": null,\n" +
                "            \"author_flair_richtext\": [],\n" +
                "            \"author_flair_text\": null,\n" +
                "            \"author_flair_type\": \"text\",\n" +
                "            \"author_fullname\": \"t2_2tjjlt1q\",\n" +
                "            \"author_is_blocked\": false,\n" +
                "            \"author_patreon_flair\": false,\n" +
                "            \"author_premium\": true,\n" +
                "            \"awarders\": [],\n" +
                "            \"can_mod_post\": false,\n" +
                "            \"contest_mode\": false,\n" +
                "            \"created_utc\": 1636906316,\n" +
                "            \"domain\": \"self.CryptoMoonShots\",\n" +
                "            \"full_link\": \"https://www.reddit.com/r/CryptoMoonShots/comments/qtt1b3/pitbull_token_126m_market_cap_65m_liq_burned/\",\n" +
                "            \"gildings\": {},\n" +
                "            \"id\": \"qtt1b3\",\n" +
                "            \"is_created_from_ads_ui\": false,\n" +
                "            \"is_crosspostable\": true,\n" +
                "            \"is_meta\": false,\n" +
                "            \"is_original_content\": false,\n" +
                "            \"is_reddit_media_domain\": false,\n" +
                "            \"is_robot_indexable\": true,\n" +
                "            \"is_self\": true,\n" +
                "            \"is_video\": false,\n" +
                "            \"link_flair_background_color\": \"#ff66ac\",\n" +
                "            \"link_flair_richtext\": [],\n" +
                "            \"link_flair_template_id\": \"9a44476c-849c-11eb-871a-0e20d6e20663\",\n" +
                "            \"link_flair_text\": \"BSC Token\",\n" +
                "            \"link_flair_text_color\": \"dark\",\n" +
                "            \"link_flair_type\": \"text\",\n" +
                "            \"locked\": false,\n" +
                "            \"media_only\": false,\n" +
                "            \"no_follow\": true,\n" +
                "            \"num_comments\": 1,\n" +
                "            \"num_crossposts\": 0,\n" +
                "            \"over_18\": false,\n" +
                "            \"parent_whitelist_status\": \"all_ads\",\n" +
                "            \"permalink\": \"/r/CryptoMoonShots/comments/qtt1b3/pitbull_token_126m_market_cap_65m_liq_burned/\",\n" +
                "            \"pinned\": false,\n" +
                "            \"post_hint\": \"self\",\n" +
                "            \"preview\": {\n" +
                "                \"enabled\": false,\n" +
                "                \"images\": [\n" +
                "                    {\n" +
                "                        \"id\": \"sXPn6MC9ov6TN1A4gmssKVpxfejNtFtT7aKJVZdSwQo\",\n" +
                "                        \"resolutions\": [\n" +
                "                            {\n" +
                "                                \"height\": 108,\n" +
                "                                \"url\": \"https://external-preview.redd.it/dnl89auPvTP5CcyQQtVYItBnE8Fij64g6rHDqnkwR30.jpg?width=108&amp;crop=smart&amp;auto=webp&amp;s=f3fcb114150867cc105b755956745e327286e0b0\",\n" +
                "                                \"width\": 108\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 216,\n" +
                "                                \"url\": \"https://external-preview.redd.it/dnl89auPvTP5CcyQQtVYItBnE8Fij64g6rHDqnkwR30.jpg?width=216&amp;crop=smart&amp;auto=webp&amp;s=b13a23b149e48ab122facfb13cdcd361a319e8dd\",\n" +
                "                                \"width\": 216\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 320,\n" +
                "                                \"url\": \"https://external-preview.redd.it/dnl89auPvTP5CcyQQtVYItBnE8Fij64g6rHDqnkwR30.jpg?width=320&amp;crop=smart&amp;auto=webp&amp;s=d3ce5756432fd529b9be6d6a3375c1dc893ec1a7\",\n" +
                "                                \"width\": 320\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"source\": {\n" +
                "                            \"height\": 320,\n" +
                "                            \"url\": \"https://external-preview.redd.it/dnl89auPvTP5CcyQQtVYItBnE8Fij64g6rHDqnkwR30.jpg?auto=webp&amp;s=7fecdbffafd4e4cc4df222a4719430617585ba4d\",\n" +
                "                            \"width\": 320\n" +
                "                        },\n" +
                "                        \"variants\": {}\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            \"pwls\": 6,\n" +
                "            \"retrieved_on\": 1636906327,\n" +
                "            \"score\": 1,\n" +
                "            \"selftext\": \"$PIT is safe by design. It is an ownership-renounced token with each buy and sell automatically contributing to a liquidity pool that is locked forever. It is impossible to modify Pitbull\\u2019s contract , and it is impossible to pull liquidity from it, which makes the project one of the securest all over BSC. The team behind Pitbull is a fully volunteer team since beginning. As it comes to burning, because of the safe contract concept, there is no manual burn. As a community-driven project with no dev/team wallets, the volunteer Pitbull Team opted to create a community wallet that members can donate in order to further build the project. Listings, shelter donations, advertisement expenses are met by this community funds. Pitbull just shared the new roadmap with the community:\\n\\n# Roadmap:\\n\\nThe new roadmap marks the start of a New Chapter for Pitbull. It is incredible what's planned for the future. The roadmap is also featured on Yahoo Finance:\\n\\n\\u2705**PitSafe Dapp** Integration of **ETHEREUM, KUCOIN, SOLANA, CARDANO, &amp; POLYGON CHAIN**\\n\\n\\u2705Listings on **Tier-1** Exchanges\\n\\n\\u2705**PitMag** (Pitbull Magazine), The First Communication Media by a Token with a Unique Concept\\n\\n\\u2705PIT Telegram **PriceBot** Launch for all Crypto Projects\\n\\n\\u2705Release of Pitbull's First **Premium NFT Collection** of Special 3D Character cards\\n\\n\\u2705**Marketing Push/ Campaigns**\\n\\n\\u2705Press Releases on Top News Networks &amp; Wires Globally\\n\\n\\u2705Influencer Deals &amp; Long -term Collaborations\\n\\n\\u2705**PitDiscorvery** Dapp Launch, Research Tool for Crypto Projects\\n\\n\\u2705Listing $PIT on Dex, Swaps &amp; Pools\\n\\n\\u2705Strategic Partnerships\\n\\n\\u2705**PitStop** Performance Upgrade\\n\\n\\u2705**PitCharts**, Product Ads Submits\\n\\n\\u2705Multiple **PitBurn** Events\\n\\n\\u2705**Pitbull NFT Collaborations**\\n\\n\\u2705**Whitepaper Update v2.0** with New Developments &amp; More Language Options\\n\\n\\u2705Partnerships &amp; Donation Events with Shelter &amp; Animal Hospitals in Worldwide\\n\\n\\u2705Production of **PIT Merchandise**\\n\\n\\u2705**PitStore** \\\\- Merchant Website Launch\\n\\n\\u2705\\\\*\\\\*%60 of Total Supply\\\\`s Burn\\\\*\\\\* with Transactions\\n\\n\\u2705**New Innovative Pitbull NFT Series**\\n\\n\\u2705Pitbull **Staking in DEX and CEX**\\n\\n\\u2705**PitGames** Launch\\n\\n\\u2705**PIT PlayToEarn Gaming Model (PIT P2E gaming system)**\\n\\n\\u2705**PitGames** Integration into **Metaverse -** In **Augmented Reality (AR)** &amp; **Metaverse** user can get real life rewards or use rewards as **donations to vet clinics or animal shelters** globally.\\n\\n\\u2705**Online PIT Payment** Options as a Real-world Currency &amp; Shopping with **Credit Card**\\n\\n\\u2705PIT's Evolution into **Governance Token**\\n\\n# What is already done\\n\\nAfter more than 7 months, it is incredible what the team of volunteers has achieved.\\n\\n\\u2705 Built an own ecosystem with PitSafe, PitSwap, PitFarm, PitStop with PitLottery and PitCharts\\n\\n\\u2705 Hotbit listed\\n\\n\\u2705 LATOKEN listed\\n\\n\\u2705 Cointiger listed\\n\\n\\u2705 Indoex listed\\n\\n\\u2705 WhiteBit listed\\n\\n\\u2705 Tao finance, pig finance partnerships formed\\n\\n\\u2705 Donation shelter pools\\n\\n\\u2705 Website redesign\\n\\n\\u2705 Partnership with UniTrackerApp\\n\\n\\ud83d\\udd10PitSafe: PitSafe is a comprehensive BSC DeFi Asset Manager where investors who have $PIT in their wallets can obtain in-depth information about each token on the Blockchains. PitSafe offers exciting products for token developers and investors.\\n\\n\\ud83d\\udd01PitSwap PitSwap is the place where you can BUY $PIT via the right way; V1 + 6% slippage. PitSwap will be our new place to buy and sell $PIT. No more annoying disclaimers from PanCakeSwap about the V1/V2 problem they face. PitSwap will be using PanCakeSwap V1, which uses the right liquidity pool.\\n\\n\\ud83c\\udfe0PitFarm PitFarm is the place where you can stake PIT-BNB V1 for points to redeem official Pitbull NFTs, or buy them straight out. These NFTs can be traded in the marketplace, and the sales will go towards the Pitbull community fund and artist as a minting fee. The funds raised will go towards charity, project development, and burning Pitbull tokens.\\n\\n\\u26d4\\ufe0fPitStop: A one stop place where you can see charts, track your earnings from holding tokens &amp; much more\\n\\n\\ud83d\\udcb8PitLottery Pitlottery is a unique game\\\\~lottery where users can win more $PIT tokens by purchasing tickets with their $PITs. It will be a lottery platform rebase on Binance Smart Chain.\\n\\n\\ud83d\\udcc8PitCharts PitCharts is a tool to track your coins and their prices.\\n\\n\\ud83d\\udea8\\ud83d\\udea8\\ud83d\\udea8What makes it even more exciting is a little outlook into the future. Pitbull will enter the metaverse and take its first steps into the play-2-earn arena. There is also a new NFT Collaboration and a new NFT Collection will be available soon. Another Product in the ecosystem will be PitMag. PitMag is a Magazine where you can find latest news about cryptocurrencies and blockchain. Be excited!\\n\\nDYOR as always. If you want to know more, you can read more here:\\n\\nPitbull Contract(v1): 0xa57ac35ce91ee92caefaa8dc04140c8e232c2e50\\n\\nTG: [https://t.me/Pitbull\\\\_BSC](https://t.me/Pitbull_BSC)\\n\\nWebsite: pitbull.community\",\n" +
                "            \"send_replies\": true,\n" +
                "            \"spoiler\": false,\n" +
                "            \"stickied\": false,\n" +
                "            \"subreddit\": \"CryptoMoonShots\",\n" +
                "            \"subreddit_id\": \"t5_9e4pv\",\n" +
                "            \"subreddit_subscribers\": 1054529,\n" +
                "            \"subreddit_type\": \"public\",\n" +
                "            \"thumbnail\": \"self\",\n" +
                "            \"title\": \"\\ud83d\\udc36Pitbull Token | 126M Market Cap - 6.5M$ Liq burned forever | Listed on Mexc Global and Bkex in last 2 days - Futures trading on Mexc | Major Donation Program featured on Yahoo finance - partnered with Voohees Animal | 58.7% Tokens burnt | 341K Holders - increasing daily| \\ud83d\\udea8P2E and MetaVerse coming\",\n" +
                "            \"total_awards_received\": 0,\n" +
                "            \"treatment_tags\": [],\n" +
                "            \"upvote_ratio\": 1.0,\n" +
                "            \"url\": \"https://www.reddit.com/r/CryptoMoonShots/comments/qtt1b3/pitbull_token_126m_market_cap_65m_liq_burned/\",\n" +
                "            \"whitelist_status\": \"all_ads\",\n" +
                "            \"wls\": 6\n" +
                "        },\n" +
                "        {\n" +
                "            \"all_awardings\": [],\n" +
                "            \"allow_live_comments\": false,\n" +
                "            \"author\": \"profurket1990\",\n" +
                "            \"author_flair_css_class\": null,\n" +
                "            \"author_flair_richtext\": [],\n" +
                "            \"author_flair_text\": null,\n" +
                "            \"author_flair_type\": \"text\",\n" +
                "            \"author_fullname\": \"t2_ekcbds9r\",\n" +
                "            \"author_is_blocked\": false,\n" +
                "            \"author_patreon_flair\": false,\n" +
                "            \"author_premium\": false,\n" +
                "            \"awarders\": [],\n" +
                "            \"can_mod_post\": false,\n" +
                "            \"contest_mode\": false,\n" +
                "            \"created_utc\": 1636905443,\n" +
                "            \"domain\": \"cormarenomeanssis.ga\",\n" +
                "            \"full_link\": \"https://www.reddit.com/r/u_profurket1990/comments/qtsq0f/breaking_news_8211_todays_top_breaking_news_8211/\",\n" +
                "            \"gildings\": {},\n" +
                "            \"id\": \"qtsq0f\",\n" +
                "            \"is_created_from_ads_ui\": false,\n" +
                "            \"is_crosspostable\": true,\n" +
                "            \"is_meta\": false,\n" +
                "            \"is_original_content\": false,\n" +
                "            \"is_reddit_media_domain\": false,\n" +
                "            \"is_robot_indexable\": true,\n" +
                "            \"is_self\": false,\n" +
                "            \"is_video\": false,\n" +
                "            \"link_flair_background_color\": \"\",\n" +
                "            \"link_flair_richtext\": [],\n" +
                "            \"link_flair_text_color\": \"dark\",\n" +
                "            \"link_flair_type\": \"text\",\n" +
                "            \"locked\": false,\n" +
                "            \"media_only\": false,\n" +
                "            \"no_follow\": false,\n" +
                "            \"num_comments\": 0,\n" +
                "            \"num_crossposts\": 0,\n" +
                "            \"over_18\": false,\n" +
                "            \"permalink\": \"/r/u_profurket1990/comments/qtsq0f/breaking_news_8211_todays_top_breaking_news_8211/\",\n" +
                "            \"pinned\": false,\n" +
                "            \"post_hint\": \"link\",\n" +
                "            \"preview\": {\n" +
                "                \"enabled\": false,\n" +
                "                \"images\": [\n" +
                "                    {\n" +
                "                        \"id\": \"Si58KEXNQHTlh4W4BTadb3sxBJVCFPRy5cse8tbuP68\",\n" +
                "                        \"resolutions\": [\n" +
                "                            {\n" +
                "                                \"height\": 125,\n" +
                "                                \"url\": \"https://external-preview.redd.it/V0HKYBIZxbne_qKzYgmv93e6wpvDMEZ-Jj_dUUbC8sk.jpg?width=108&amp;crop=smart&amp;auto=webp&amp;s=57a5a4a02c2e6ebb3acfae4fd73cf8bd34465daf\",\n" +
                "                                \"width\": 108\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 250,\n" +
                "                                \"url\": \"https://external-preview.redd.it/V0HKYBIZxbne_qKzYgmv93e6wpvDMEZ-Jj_dUUbC8sk.jpg?width=216&amp;crop=smart&amp;auto=webp&amp;s=42dc4a721ff4e0d1ce8d368f3b9be3e3bd7e1d90\",\n" +
                "                                \"width\": 216\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 370,\n" +
                "                                \"url\": \"https://external-preview.redd.it/V0HKYBIZxbne_qKzYgmv93e6wpvDMEZ-Jj_dUUbC8sk.jpg?width=320&amp;crop=smart&amp;auto=webp&amp;s=c033bb19944d00d1d5768bd7a2a3da4c8c329968\",\n" +
                "                                \"width\": 320\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 741,\n" +
                "                                \"url\": \"https://external-preview.redd.it/V0HKYBIZxbne_qKzYgmv93e6wpvDMEZ-Jj_dUUbC8sk.jpg?width=640&amp;crop=smart&amp;auto=webp&amp;s=3ac39b9d8a11c677886a18a302a4a54f2d42f7da\",\n" +
                "                                \"width\": 640\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 1112,\n" +
                "                                \"url\": \"https://external-preview.redd.it/V0HKYBIZxbne_qKzYgmv93e6wpvDMEZ-Jj_dUUbC8sk.jpg?width=960&amp;crop=smart&amp;auto=webp&amp;s=80aa4ffc913c47ce069f3a960ceee2c34261d3dc\",\n" +
                "                                \"width\": 960\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 1252,\n" +
                "                                \"url\": \"https://external-preview.redd.it/V0HKYBIZxbne_qKzYgmv93e6wpvDMEZ-Jj_dUUbC8sk.jpg?width=1080&amp;crop=smart&amp;auto=webp&amp;s=3e605677f507e818580bfc30e7129cb09db229ee\",\n" +
                "                                \"width\": 1080\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"source\": {\n" +
                "                            \"height\": 1252,\n" +
                "                            \"url\": \"https://external-preview.redd.it/V0HKYBIZxbne_qKzYgmv93e6wpvDMEZ-Jj_dUUbC8sk.jpg?auto=webp&amp;s=2a4449ae3f7230674e3408e8ce41d01e269993f7\",\n" +
                "                            \"width\": 1080\n" +
                "                        },\n" +
                "                        \"variants\": {}\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            \"retrieved_on\": 1636905454,\n" +
                "            \"score\": 1,\n" +
                "            \"selftext\": \"\",\n" +
                "            \"send_replies\": true,\n" +
                "            \"spoiler\": false,\n" +
                "            \"stickied\": false,\n" +
                "            \"subreddit\": \"u_profurket1990\",\n" +
                "            \"subreddit_id\": \"t5_51ploe\",\n" +
                "            \"subreddit_subscribers\": 0,\n" +
                "            \"subreddit_type\": \"user\",\n" +
                "            \"suggested_sort\": \"qa\",\n" +
                "            \"thumbnail\": \"https://b.thumbs.redditmedia.com/iBs9sPYf99KymLnn1jT4ORIbJ6IjJrtv0VfQ_UxeYec.jpg\",\n" +
                "            \"thumbnail_height\": 140,\n" +
                "            \"thumbnail_width\": 140,\n" +
                "            \"title\": \"Breaking News &amp;#8211; Todays top Breaking News &amp;#8211; Todays top 100 search engine keyword searches: pornsearch4adults.com 1 sex 2 porn 3 meme 4 redtube 5 youporn 6 meme 7 pussy 8 yahoo 9 hentai 10 youtube 11 milf 12 President Trump 13 boobs 14 free porn 15 hannah montana 16 89.com 17 ...\",\n" +
                "            \"total_awards_received\": 0,\n" +
                "            \"treatment_tags\": [],\n" +
                "            \"upvote_ratio\": 1.0,\n" +
                "            \"url\": \"https://cormarenomeanssis.ga/breaking-news-todays-top/\",\n" +
                "            \"url_overridden_by_dest\": \"https://cormarenomeanssis.ga/breaking-news-todays-top/\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"all_awardings\": [],\n" +
                "            \"allow_live_comments\": false,\n" +
                "            \"author\": \"przemkas\",\n" +
                "            \"author_flair_css_class\": null,\n" +
                "            \"author_flair_richtext\": [],\n" +
                "            \"author_flair_text\": null,\n" +
                "            \"author_flair_type\": \"text\",\n" +
                "            \"author_fullname\": \"t2_17h845x7\",\n" +
                "            \"author_is_blocked\": false,\n" +
                "            \"author_patreon_flair\": false,\n" +
                "            \"author_premium\": false,\n" +
                "            \"awarders\": [],\n" +
                "            \"can_mod_post\": false,\n" +
                "            \"contest_mode\": false,\n" +
                "            \"created_utc\": 1636905416,\n" +
                "            \"domain\": \"youtube.com\",\n" +
                "            \"full_link\": \"https://www.reddit.com/r/FreshNewsToday/comments/qtspo7/nfl_dfs_picks_45_hour_live_before_lock_week_10/\",\n" +
                "            \"gildings\": {},\n" +
                "            \"id\": \"qtspo7\",\n" +
                "            \"is_created_from_ads_ui\": false,\n" +
                "            \"is_crosspostable\": false,\n" +
                "            \"is_meta\": false,\n" +
                "            \"is_original_content\": false,\n" +
                "            \"is_reddit_media_domain\": false,\n" +
                "            \"is_robot_indexable\": false,\n" +
                "            \"is_self\": false,\n" +
                "            \"is_video\": false,\n" +
                "            \"link_flair_background_color\": \"\",\n" +
                "            \"link_flair_richtext\": [],\n" +
                "            \"link_flair_text_color\": \"dark\",\n" +
                "            \"link_flair_type\": \"text\",\n" +
                "            \"locked\": false,\n" +
                "            \"media\": {\n" +
                "                \"oembed\": {\n" +
                "                    \"author_name\": \"Awesemo DFS - Daily Fantasy Sports Advice\",\n" +
                "                    \"author_url\": \"https://www.youtube.com/c/Awesemo\",\n" +
                "                    \"height\": 200,\n" +
                "                    \"html\": \"&lt;iframe width=\\\"267\\\" height=\\\"200\\\" src=\\\"https://www.youtube.com/embed/Ic-g0J5rdI8?feature=oembed&amp;enablejsapi=1\\\" frameborder=\\\"0\\\" allow=\\\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\\\" allowfullscreen&gt;&lt;/iframe&gt;\",\n" +
                "                    \"provider_name\": \"YouTube\",\n" +
                "                    \"provider_url\": \"https://www.youtube.com/\",\n" +
                "                    \"thumbnail_height\": 360,\n" +
                "                    \"thumbnail_url\": \"https://i.ytimg.com/vi/Ic-g0J5rdI8/hqdefault.jpg\",\n" +
                "                    \"thumbnail_width\": 480,\n" +
                "                    \"title\": \"NFL DFS Picks: 4.5 HOUR Live Before Lock WEEK 10 | Daily Fantasy on DraftKings, FanDuel, Yahoo\",\n" +
                "                    \"type\": \"video\",\n" +
                "                    \"version\": \"1.0\",\n" +
                "                    \"width\": 267\n" +
                "                },\n" +
                "                \"type\": \"youtube.com\"\n" +
                "            },\n" +
                "            \"media_embed\": {\n" +
                "                \"content\": \"&lt;iframe width=\\\"267\\\" height=\\\"200\\\" src=\\\"https://www.youtube.com/embed/Ic-g0J5rdI8?feature=oembed&amp;enablejsapi=1\\\" frameborder=\\\"0\\\" allow=\\\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\\\" allowfullscreen&gt;&lt;/iframe&gt;\",\n" +
                "                \"height\": 200,\n" +
                "                \"scrolling\": false,\n" +
                "                \"width\": 267\n" +
                "            },\n" +
                "            \"media_only\": false,\n" +
                "            \"no_follow\": true,\n" +
                "            \"num_comments\": 0,\n" +
                "            \"num_crossposts\": 0,\n" +
                "            \"over_18\": false,\n" +
                "            \"parent_whitelist_status\": \"no_ads\",\n" +
                "            \"permalink\": \"/r/FreshNewsToday/comments/qtspo7/nfl_dfs_picks_45_hour_live_before_lock_week_10/\",\n" +
                "            \"pinned\": false,\n" +
                "            \"post_hint\": \"rich:video\",\n" +
                "            \"preview\": {\n" +
                "                \"enabled\": false,\n" +
                "                \"images\": [\n" +
                "                    {\n" +
                "                        \"id\": \"xWIzFnDaj6VQF9_UtGvSuvwT-YODhzlQaZuLgA_zzOo\",\n" +
                "                        \"resolutions\": [\n" +
                "                            {\n" +
                "                                \"height\": 81,\n" +
                "                                \"url\": \"https://external-preview.redd.it/-REMY8pVbxEa8Q2fOcwE_g5eooITXi6BVat30SbDL30.jpg?width=108&amp;crop=smart&amp;auto=webp&amp;s=860d321c0b5c1179abfee2ea4f66896624f5ac7c\",\n" +
                "                                \"width\": 108\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 162,\n" +
                "                                \"url\": \"https://external-preview.redd.it/-REMY8pVbxEa8Q2fOcwE_g5eooITXi6BVat30SbDL30.jpg?width=216&amp;crop=smart&amp;auto=webp&amp;s=83218e19801a1b51ac56259ae7c6c04cd15f2673\",\n" +
                "                                \"width\": 216\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 240,\n" +
                "                                \"url\": \"https://external-preview.redd.it/-REMY8pVbxEa8Q2fOcwE_g5eooITXi6BVat30SbDL30.jpg?width=320&amp;crop=smart&amp;auto=webp&amp;s=1283c1900bcce9e2c0f0a5a21db59a2535fa2a4e\",\n" +
                "                                \"width\": 320\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"source\": {\n" +
                "                            \"height\": 360,\n" +
                "                            \"url\": \"https://external-preview.redd.it/-REMY8pVbxEa8Q2fOcwE_g5eooITXi6BVat30SbDL30.jpg?auto=webp&amp;s=d6429e265558aa826e00695cca63d4291dc7408e\",\n" +
                "                            \"width\": 480\n" +
                "                        },\n" +
                "                        \"variants\": {}\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            \"pwls\": 0,\n" +
                "            \"removed_by_category\": \"reddit\",\n" +
                "            \"retrieved_on\": 1636905427,\n" +
                "            \"score\": 1,\n" +
                "            \"secure_media\": {\n" +
                "                \"oembed\": {\n" +
                "                    \"author_name\": \"Awesemo DFS - Daily Fantasy Sports Advice\",\n" +
                "                    \"author_url\": \"https://www.youtube.com/c/Awesemo\",\n" +
                "                    \"height\": 200,\n" +
                "                    \"html\": \"&lt;iframe width=\\\"267\\\" height=\\\"200\\\" src=\\\"https://www.youtube.com/embed/Ic-g0J5rdI8?feature=oembed&amp;enablejsapi=1\\\" frameborder=\\\"0\\\" allow=\\\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\\\" allowfullscreen&gt;&lt;/iframe&gt;\",\n" +
                "                    \"provider_name\": \"YouTube\",\n" +
                "                    \"provider_url\": \"https://www.youtube.com/\",\n" +
                "                    \"thumbnail_height\": 360,\n" +
                "                    \"thumbnail_url\": \"https://i.ytimg.com/vi/Ic-g0J5rdI8/hqdefault.jpg\",\n" +
                "                    \"thumbnail_width\": 480,\n" +
                "                    \"title\": \"NFL DFS Picks: 4.5 HOUR Live Before Lock WEEK 10 | Daily Fantasy on DraftKings, FanDuel, Yahoo\",\n" +
                "                    \"type\": \"video\",\n" +
                "                    \"version\": \"1.0\",\n" +
                "                    \"width\": 267\n" +
                "                },\n" +
                "                \"type\": \"youtube.com\"\n" +
                "            },\n" +
                "            \"secure_media_embed\": {\n" +
                "                \"content\": \"&lt;iframe width=\\\"267\\\" height=\\\"200\\\" src=\\\"https://www.youtube.com/embed/Ic-g0J5rdI8?feature=oembed&amp;enablejsapi=1\\\" frameborder=\\\"0\\\" allow=\\\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\\\" allowfullscreen&gt;&lt;/iframe&gt;\",\n" +
                "                \"height\": 200,\n" +
                "                \"media_domain_url\": \"https://www.redditmedia.com/mediaembed/qtspo7\",\n" +
                "                \"scrolling\": false,\n" +
                "                \"width\": 267\n" +
                "            },\n" +
                "            \"selftext\": \"\",\n" +
                "            \"send_replies\": false,\n" +
                "            \"spoiler\": false,\n" +
                "            \"stickied\": false,\n" +
                "            \"subreddit\": \"FreshNewsToday\",\n" +
                "            \"subreddit_id\": \"t5_x2hwp\",\n" +
                "            \"subreddit_subscribers\": 911,\n" +
                "            \"subreddit_type\": \"restricted\",\n" +
                "            \"thumbnail\": \"https://b.thumbs.redditmedia.com/yBl7-Qa06VEErH6G8lzTXxlbyEzLLkUHuNYYvIYGKaA.jpg\",\n" +
                "            \"thumbnail_height\": 105,\n" +
                "            \"thumbnail_width\": 140,\n" +
                "            \"title\": \"NFL DFS Picks: 4.5 HOUR Live Before Lock WEEK 10 | Daily Fantasy on DraftKings, FanDuel, Yahoo - Awesemo DFS - Daily Fantasy Sports Advice\",\n" +
                "            \"total_awards_received\": 0,\n" +
                "            \"treatment_tags\": [],\n" +
                "            \"upvote_ratio\": 1.0,\n" +
                "            \"url\": \"https://www.youtube.com/watch?v=Ic-g0J5rdI8\",\n" +
                "            \"url_overridden_by_dest\": \"https://www.youtube.com/watch?v=Ic-g0J5rdI8\",\n" +
                "            \"whitelist_status\": \"no_ads\",\n" +
                "            \"wls\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"all_awardings\": [],\n" +
                "            \"allow_live_comments\": false,\n" +
                "            \"author\": \"Michabo\",\n" +
                "            \"author_flair_css_class\": null,\n" +
                "            \"author_flair_richtext\": [],\n" +
                "            \"author_flair_text\": null,\n" +
                "            \"author_flair_type\": \"text\",\n" +
                "            \"author_fullname\": \"t2_9bnyd\",\n" +
                "            \"author_is_blocked\": false,\n" +
                "            \"author_patreon_flair\": false,\n" +
                "            \"author_premium\": false,\n" +
                "            \"awarders\": [],\n" +
                "            \"can_mod_post\": false,\n" +
                "            \"contest_mode\": false,\n" +
                "            \"created_utc\": 1636904917,\n" +
                "            \"domain\": \"self.airdropalertcom\",\n" +
                "            \"full_link\": \"https://www.reddit.com/r/airdropalertcom/comments/qtsjgu/anfs_airdrop_alert_10_in_anfs_coins_to_claim/\",\n" +
                "            \"gildings\": {},\n" +
                "            \"id\": \"qtsjgu\",\n" +
                "            \"is_created_from_ads_ui\": false,\n" +
                "            \"is_crosspostable\": true,\n" +
                "            \"is_meta\": false,\n" +
                "            \"is_original_content\": false,\n" +
                "            \"is_reddit_media_domain\": false,\n" +
                "            \"is_robot_indexable\": true,\n" +
                "            \"is_self\": true,\n" +
                "            \"is_video\": false,\n" +
                "            \"link_flair_background_color\": \"\",\n" +
                "            \"link_flair_richtext\": [],\n" +
                "            \"link_flair_text_color\": \"dark\",\n" +
                "            \"link_flair_type\": \"text\",\n" +
                "            \"locked\": false,\n" +
                "            \"media_only\": false,\n" +
                "            \"no_follow\": false,\n" +
                "            \"num_comments\": 0,\n" +
                "            \"num_crossposts\": 0,\n" +
                "            \"over_18\": false,\n" +
                "            \"parent_whitelist_status\": \"all_ads\",\n" +
                "            \"permalink\": \"/r/airdropalertcom/comments/qtsjgu/anfs_airdrop_alert_10_in_anfs_coins_to_claim/\",\n" +
                "            \"pinned\": false,\n" +
                "            \"post_hint\": \"self\",\n" +
                "            \"preview\": {\n" +
                "                \"enabled\": false,\n" +
                "                \"images\": [\n" +
                "                    {\n" +
                "                        \"id\": \"DD8fdaRrjkBMJMjB_poN55mc3mGrBmzNKYrM1GHUll0\",\n" +
                "                        \"resolutions\": [\n" +
                "                            {\n" +
                "                                \"height\": 56,\n" +
                "                                \"url\": \"https://external-preview.redd.it/lVpebfkchZndha9IKG7Nf1xn2mB9gqHfWn5p2jFQFfU.jpg?width=108&amp;crop=smart&amp;auto=webp&amp;s=1a8cd1d874c8e6f0f0fb362507f41b381475f928\",\n" +
                "                                \"width\": 108\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 113,\n" +
                "                                \"url\": \"https://external-preview.redd.it/lVpebfkchZndha9IKG7Nf1xn2mB9gqHfWn5p2jFQFfU.jpg?width=216&amp;crop=smart&amp;auto=webp&amp;s=3d45a1c67d18270d47d9640c173466538c34fb96\",\n" +
                "                                \"width\": 216\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 167,\n" +
                "                                \"url\": \"https://external-preview.redd.it/lVpebfkchZndha9IKG7Nf1xn2mB9gqHfWn5p2jFQFfU.jpg?width=320&amp;crop=smart&amp;auto=webp&amp;s=fac401347ca8dabc4a76989b43cd1f295c3a6f70\",\n" +
                "                                \"width\": 320\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 334,\n" +
                "                                \"url\": \"https://external-preview.redd.it/lVpebfkchZndha9IKG7Nf1xn2mB9gqHfWn5p2jFQFfU.jpg?width=640&amp;crop=smart&amp;auto=webp&amp;s=d1a6aad6bd943411a8b263bb1e072587223dbdc8\",\n" +
                "                                \"width\": 640\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 502,\n" +
                "                                \"url\": \"https://external-preview.redd.it/lVpebfkchZndha9IKG7Nf1xn2mB9gqHfWn5p2jFQFfU.jpg?width=960&amp;crop=smart&amp;auto=webp&amp;s=99b9c59cb1ca960d585450d9373d30330646f7fb\",\n" +
                "                                \"width\": 960\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 565,\n" +
                "                                \"url\": \"https://external-preview.redd.it/lVpebfkchZndha9IKG7Nf1xn2mB9gqHfWn5p2jFQFfU.jpg?width=1080&amp;crop=smart&amp;auto=webp&amp;s=be37af0341c91eebdcf155a6222fc0686ec07f06\",\n" +
                "                                \"width\": 1080\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"source\": {\n" +
                "                            \"height\": 628,\n" +
                "                            \"url\": \"https://external-preview.redd.it/lVpebfkchZndha9IKG7Nf1xn2mB9gqHfWn5p2jFQFfU.jpg?auto=webp&amp;s=e38ebb48cfc31a294cadbfe66d5b6e9a3f07527e\",\n" +
                "                            \"width\": 1200\n" +
                "                        },\n" +
                "                        \"variants\": {}\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            \"pwls\": 6,\n" +
                "            \"retrieved_on\": 1636904928,\n" +
                "            \"score\": 1,\n" +
                "            \"selftext\": \" ANFS Airdrop is worth\\u00a0**$10** of $**ANFS** for **10,000** lucky participants.\\u00a0  \\n\\n\\n**About\\u00a0ANFS**  \\n\\n\\nANFS is the infrastructure aiming\\u00a0to increase operational efficiency and scalability of [blockchain](https://blogs.airdropalert.com/tag/blockchain/) networks. ANFS's original [HPOS](https://www.anfs.network/hops) consensus mechansim can provide unparalleled high throughput, scalability and high availability, with\\u00a0extremely low cost, close to web-level processing speed and instant access to massive data. ANFS is featured on [Yahoo Finance](https://finance.yahoo.com/news/anfss-high-performance-blockchain-consensus-154900841.html). \\n\\n&amp;#x200B;\\n\\nClaim airdrop \\u27a4 [https://airdropalert.com/anfs-airdrop](https://airdropalert.com/anfs-airdrop)\",\n" +
                "            \"send_replies\": true,\n" +
                "            \"spoiler\": false,\n" +
                "            \"stickied\": false,\n" +
                "            \"subreddit\": \"airdropalertcom\",\n" +
                "            \"subreddit_id\": \"t5_xgrc3\",\n" +
                "            \"subreddit_subscribers\": 8629,\n" +
                "            \"subreddit_type\": \"public\",\n" +
                "            \"thumbnail\": \"self\",\n" +
                "            \"title\": \"ANFS AIRDROP ALERT \\ud83d\\udce2 $10 in $ANFS coins to claim\",\n" +
                "            \"total_awards_received\": 0,\n" +
                "            \"treatment_tags\": [],\n" +
                "            \"upvote_ratio\": 1.0,\n" +
                "            \"url\": \"https://www.reddit.com/r/airdropalertcom/comments/qtsjgu/anfs_airdrop_alert_10_in_anfs_coins_to_claim/\",\n" +
                "            \"whitelist_status\": \"all_ads\",\n" +
                "            \"wls\": 6\n" +
                "        },\n" +
                "        {\n" +
                "            \"all_awardings\": [],\n" +
                "            \"allow_live_comments\": false,\n" +
                "            \"author\": \"Barbarossa-Bey\",\n" +
                "            \"author_flair_css_class\": null,\n" +
                "            \"author_flair_richtext\": [],\n" +
                "            \"author_flair_text\": null,\n" +
                "            \"author_flair_type\": \"text\",\n" +
                "            \"author_fullname\": \"t2_6z2csbas\",\n" +
                "            \"author_is_blocked\": false,\n" +
                "            \"author_patreon_flair\": false,\n" +
                "            \"author_premium\": false,\n" +
                "            \"awarders\": [],\n" +
                "            \"can_mod_post\": false,\n" +
                "            \"contest_mode\": false,\n" +
                "            \"created_utc\": 1636904861,\n" +
                "            \"domain\": \"self.altcoin_news\",\n" +
                "            \"full_link\": \"https://www.reddit.com/r/altcoin_news/comments/qtsisv/lunar_project/\",\n" +
                "            \"gildings\": {},\n" +
                "            \"id\": \"qtsisv\",\n" +
                "            \"is_created_from_ads_ui\": false,\n" +
                "            \"is_crosspostable\": true,\n" +
                "            \"is_meta\": false,\n" +
                "            \"is_original_content\": false,\n" +
                "            \"is_reddit_media_domain\": false,\n" +
                "            \"is_robot_indexable\": true,\n" +
                "            \"is_self\": true,\n" +
                "            \"is_video\": false,\n" +
                "            \"link_flair_background_color\": \"#ffd635\",\n" +
                "            \"link_flair_richtext\": [\n" +
                "                {\n" +
                "                    \"e\": \"text\",\n" +
                "                    \"t\": \"Discussion\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"link_flair_template_id\": \"f7c3bf24-9c78-11ea-af2c-0ec246f4466d\",\n" +
                "            \"link_flair_text\": \"Discussion\",\n" +
                "            \"link_flair_text_color\": \"dark\",\n" +
                "            \"link_flair_type\": \"richtext\",\n" +
                "            \"locked\": false,\n" +
                "            \"media_only\": false,\n" +
                "            \"no_follow\": true,\n" +
                "            \"num_comments\": 0,\n" +
                "            \"num_crossposts\": 0,\n" +
                "            \"over_18\": false,\n" +
                "            \"parent_whitelist_status\": \"all_ads\",\n" +
                "            \"permalink\": \"/r/altcoin_news/comments/qtsisv/lunar_project/\",\n" +
                "            \"pinned\": false,\n" +
                "            \"post_hint\": \"self\",\n" +
                "            \"preview\": {\n" +
                "                \"enabled\": false,\n" +
                "                \"images\": [\n" +
                "                    {\n" +
                "                        \"id\": \"NrJE3nsrBAoQI5YI3HuYzsKXLsMylgbmS0mIDRhzoSY\",\n" +
                "                        \"resolutions\": [\n" +
                "                            {\n" +
                "                                \"height\": 108,\n" +
                "                                \"url\": \"https://external-preview.redd.it/wwn0INCPr9KdyzRoLBz3SFsoBlWzUWh8qe8_fmJQ4tM.jpg?width=108&amp;crop=smart&amp;auto=webp&amp;s=d9fbf4f76811285659e3c43b44f98bbd63ec6ad8\",\n" +
                "                                \"width\": 108\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 216,\n" +
                "                                \"url\": \"https://external-preview.redd.it/wwn0INCPr9KdyzRoLBz3SFsoBlWzUWh8qe8_fmJQ4tM.jpg?width=216&amp;crop=smart&amp;auto=webp&amp;s=6948143f730d8e7193bfca14d1ed80b9b1440516\",\n" +
                "                                \"width\": 216\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 320,\n" +
                "                                \"url\": \"https://external-preview.redd.it/wwn0INCPr9KdyzRoLBz3SFsoBlWzUWh8qe8_fmJQ4tM.jpg?width=320&amp;crop=smart&amp;auto=webp&amp;s=9bd2d89b430fbaf3896f3101a8d986929028f9ae\",\n" +
                "                                \"width\": 320\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"source\": {\n" +
                "                            \"height\": 320,\n" +
                "                            \"url\": \"https://external-preview.redd.it/wwn0INCPr9KdyzRoLBz3SFsoBlWzUWh8qe8_fmJQ4tM.jpg?auto=webp&amp;s=99a56f803583be576fc376531d0163d3a3edd748\",\n" +
                "                            \"width\": 320\n" +
                "                        },\n" +
                "                        \"variants\": {}\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            \"pwls\": 6,\n" +
                "            \"retrieved_on\": 1636904873,\n" +
                "            \"score\": 1,\n" +
                "            \"selftext\": \"Lunar {LNR}: A BSC project with a phenomenal use case and great early traction. They've been featured in Yahoo! Finance, MarketWatch, Business Insider, and more! Lunar is streamlining the unnecessarily difficult process of microcap token trading into a single, frictionless application. - Revolutionary DEX Wallet App - Daily Passive Rewards for Holders - KYC-Verified Presale - NFT collection with Passive Earnings - Great Team &amp; Engaged Community Telegram: https://t.me/lnrDefi Website: lunardefi.com\",\n" +
                "            \"send_replies\": true,\n" +
                "            \"spoiler\": false,\n" +
                "            \"stickied\": false,\n" +
                "            \"subreddit\": \"altcoin_news\",\n" +
                "            \"subreddit_id\": \"t5_3equt\",\n" +
                "            \"subreddit_subscribers\": 33258,\n" +
                "            \"subreddit_type\": \"public\",\n" +
                "            \"thumbnail\": \"self\",\n" +
                "            \"title\": \"Lunar project\",\n" +
                "            \"total_awards_received\": 0,\n" +
                "            \"treatment_tags\": [],\n" +
                "            \"upvote_ratio\": 1.0,\n" +
                "            \"url\": \"https://www.reddit.com/r/altcoin_news/comments/qtsisv/lunar_project/\",\n" +
                "            \"whitelist_status\": \"all_ads\",\n" +
                "            \"wls\": 6\n" +
                "        },\n" +
                "        {\n" +
                "            \"all_awardings\": [],\n" +
                "            \"allow_live_comments\": false,\n" +
                "            \"author\": \"HyperPr024\",\n" +
                "            \"author_flair_css_class\": null,\n" +
                "            \"author_flair_richtext\": [],\n" +
                "            \"author_flair_text\": null,\n" +
                "            \"author_flair_type\": \"text\",\n" +
                "            \"author_fullname\": \"t2_3n3kef7t\",\n" +
                "            \"author_is_blocked\": false,\n" +
                "            \"author_patreon_flair\": false,\n" +
                "            \"author_premium\": false,\n" +
                "            \"awarders\": [],\n" +
                "            \"can_mod_post\": false,\n" +
                "            \"contest_mode\": false,\n" +
                "            \"created_utc\": 1636903146,\n" +
                "            \"domain\": \"/r/PERSoNA/comments/qtrxmq/youve_all_heard_of_burn_my_bread_now_allow_me_to/\",\n" +
                "            \"full_link\": \"https://www.reddit.com/r/PERSoNA/comments/qtrxmq/youve_all_heard_of_burn_my_bread_now_allow_me_to/\",\n" +
                "            \"gildings\": {},\n" +
                "            \"id\": \"qtrxmq\",\n" +
                "            \"is_created_from_ads_ui\": false,\n" +
                "            \"is_crosspostable\": true,\n" +
                "            \"is_meta\": false,\n" +
                "            \"is_original_content\": false,\n" +
                "            \"is_reddit_media_domain\": false,\n" +
                "            \"is_robot_indexable\": true,\n" +
                "            \"is_self\": false,\n" +
                "            \"is_video\": true,\n" +
                "            \"link_flair_background_color\": \"#005ba1\",\n" +
                "            \"link_flair_css_class\": \"P3\",\n" +
                "            \"link_flair_richtext\": [\n" +
                "                {\n" +
                "                    \"e\": \"text\",\n" +
                "                    \"t\": \"P3\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"link_flair_template_id\": \"e3db4798-beae-11e7-a8f4-0e7ebf450124\",\n" +
                "            \"link_flair_text\": \"P3\",\n" +
                "            \"link_flair_text_color\": \"light\",\n" +
                "            \"link_flair_type\": \"richtext\",\n" +
                "            \"locked\": false,\n" +
                "            \"media_only\": false,\n" +
                "            \"no_follow\": true,\n" +
                "            \"num_comments\": 0,\n" +
                "            \"num_crossposts\": 0,\n" +
                "            \"over_18\": false,\n" +
                "            \"parent_whitelist_status\": \"no_ads\",\n" +
                "            \"permalink\": \"/r/PERSoNA/comments/qtrxmq/youve_all_heard_of_burn_my_bread_now_allow_me_to/\",\n" +
                "            \"pinned\": false,\n" +
                "            \"post_hint\": \"hosted:video\",\n" +
                "            \"preview\": {\n" +
                "                \"enabled\": false,\n" +
                "                \"images\": [\n" +
                "                    {\n" +
                "                        \"id\": \"NgVCOuCBV340gRUfhjrJOsm2cDqnLM1FOkB8azCqwbE\",\n" +
                "                        \"resolutions\": [\n" +
                "                            {\n" +
                "                                \"height\": 108,\n" +
                "                                \"url\": \"https://external-preview.redd.it/FTkfas6Z9-0cCbFVHVu-UokcLxitZ9KYRj2SaG0Yy3k.png?width=108&amp;crop=smart&amp;format=pjpg&amp;auto=webp&amp;s=b49678774fbe05173d3285753c60e2552a80bc44\",\n" +
                "                                \"width\": 108\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 216,\n" +
                "                                \"url\": \"https://external-preview.redd.it/FTkfas6Z9-0cCbFVHVu-UokcLxitZ9KYRj2SaG0Yy3k.png?width=216&amp;crop=smart&amp;format=pjpg&amp;auto=webp&amp;s=0e97659a922a9f9f4b54018e1ba61fbe9685c25a\",\n" +
                "                                \"width\": 216\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 320,\n" +
                "                                \"url\": \"https://external-preview.redd.it/FTkfas6Z9-0cCbFVHVu-UokcLxitZ9KYRj2SaG0Yy3k.png?width=320&amp;crop=smart&amp;format=pjpg&amp;auto=webp&amp;s=504d61409b5a3a099cf2586e173796ac94f98b1c\",\n" +
                "                                \"width\": 320\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 640,\n" +
                "                                \"url\": \"https://external-preview.redd.it/FTkfas6Z9-0cCbFVHVu-UokcLxitZ9KYRj2SaG0Yy3k.png?width=640&amp;crop=smart&amp;format=pjpg&amp;auto=webp&amp;s=5bad874782cd1ff1366a8f44be9331d48835a466\",\n" +
                "                                \"width\": 640\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 960,\n" +
                "                                \"url\": \"https://external-preview.redd.it/FTkfas6Z9-0cCbFVHVu-UokcLxitZ9KYRj2SaG0Yy3k.png?width=960&amp;crop=smart&amp;format=pjpg&amp;auto=webp&amp;s=3691465035cb435b2e589dfd550044767176d3d6\",\n" +
                "                                \"width\": 960\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 1080,\n" +
                "                                \"url\": \"https://external-preview.redd.it/FTkfas6Z9-0cCbFVHVu-UokcLxitZ9KYRj2SaG0Yy3k.png?width=1080&amp;crop=smart&amp;format=pjpg&amp;auto=webp&amp;s=7ab8db315d7b7f0c5912bd11f24a4a9ed5873e87\",\n" +
                "                                \"width\": 1080\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"source\": {\n" +
                "                            \"height\": 2160,\n" +
                "                            \"url\": \"https://external-preview.redd.it/FTkfas6Z9-0cCbFVHVu-UokcLxitZ9KYRj2SaG0Yy3k.png?format=pjpg&amp;auto=webp&amp;s=c08c38fef30cf32cc7755622859514def332b24e\",\n" +
                "                            \"width\": 2160\n" +
                "                        },\n" +
                "                        \"variants\": {}\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            \"pwls\": 0,\n" +
                "            \"retrieved_on\": 1636903158,\n" +
                "            \"score\": 1,\n" +
                "            \"selftext\": \"\",\n" +
                "            \"send_replies\": true,\n" +
                "            \"spoiler\": false,\n" +
                "            \"stickied\": false,\n" +
                "            \"subreddit\": \"PERSoNA\",\n" +
                "            \"subreddit_id\": \"t5_2rg0t\",\n" +
                "            \"subreddit_subscribers\": 151467,\n" +
                "            \"subreddit_type\": \"public\",\n" +
                "            \"thumbnail\": \"https://b.thumbs.redditmedia.com/OSCg6c3qEIBSFs9mnnpanlaZWw5t7Kc0qX4nCp3yuTw.jpg\",\n" +
                "            \"thumbnail_height\": 140,\n" +
                "            \"thumbnail_width\": 140,\n" +
                "            \"title\": \"You\\u2019ve all heard of \\u2018Burn my Bread\\u2019. Now allow me to introduce you to \\u2018Boing Boing My Yahoo\\u2019, a personal creation of mine\\u2026\",\n" +
                "            \"total_awards_received\": 0,\n" +
                "            \"treatment_tags\": [],\n" +
                "            \"upvote_ratio\": 1.0,\n" +
                "            \"url\": \"https://v.redd.it/xv94i1jwvkz71\",\n" +
                "            \"url_overridden_by_dest\": \"https://v.redd.it/xv94i1jwvkz71\",\n" +
                "            \"whitelist_status\": \"no_ads\",\n" +
                "            \"wls\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"all_awardings\": [],\n" +
                "            \"allow_live_comments\": false,\n" +
                "            \"author\": \"Viragova96\",\n" +
                "            \"author_flair_css_class\": null,\n" +
                "            \"author_flair_richtext\": [],\n" +
                "            \"author_flair_text\": null,\n" +
                "            \"author_flair_type\": \"text\",\n" +
                "            \"author_fullname\": \"t2_gjdsvk39\",\n" +
                "            \"author_is_blocked\": false,\n" +
                "            \"author_patreon_flair\": false,\n" +
                "            \"author_premium\": false,\n" +
                "            \"awarders\": [],\n" +
                "            \"can_mod_post\": false,\n" +
                "            \"contest_mode\": false,\n" +
                "            \"created_utc\": 1636902856,\n" +
                "            \"domain\": \"self.lnrDefi\",\n" +
                "            \"full_link\": \"https://www.reddit.com/r/lnrDefi/comments/qtru0v/lunar_lnr/\",\n" +
                "            \"gildings\": {},\n" +
                "            \"id\": \"qtru0v\",\n" +
                "            \"is_created_from_ads_ui\": false,\n" +
                "            \"is_crosspostable\": true,\n" +
                "            \"is_meta\": false,\n" +
                "            \"is_original_content\": false,\n" +
                "            \"is_reddit_media_domain\": false,\n" +
                "            \"is_robot_indexable\": true,\n" +
                "            \"is_self\": true,\n" +
                "            \"is_video\": false,\n" +
                "            \"link_flair_background_color\": \"\",\n" +
                "            \"link_flair_richtext\": [],\n" +
                "            \"link_flair_text_color\": \"dark\",\n" +
                "            \"link_flair_type\": \"text\",\n" +
                "            \"locked\": false,\n" +
                "            \"media_only\": false,\n" +
                "            \"no_follow\": true,\n" +
                "            \"num_comments\": 0,\n" +
                "            \"num_crossposts\": 0,\n" +
                "            \"over_18\": false,\n" +
                "            \"permalink\": \"/r/lnrDefi/comments/qtru0v/lunar_lnr/\",\n" +
                "            \"pinned\": false,\n" +
                "            \"post_hint\": \"self\",\n" +
                "            \"preview\": {\n" +
                "                \"enabled\": false,\n" +
                "                \"images\": [\n" +
                "                    {\n" +
                "                        \"id\": \"NrJE3nsrBAoQI5YI3HuYzsKXLsMylgbmS0mIDRhzoSY\",\n" +
                "                        \"resolutions\": [\n" +
                "                            {\n" +
                "                                \"height\": 108,\n" +
                "                                \"url\": \"https://external-preview.redd.it/wwn0INCPr9KdyzRoLBz3SFsoBlWzUWh8qe8_fmJQ4tM.jpg?width=108&amp;crop=smart&amp;auto=webp&amp;s=d9fbf4f76811285659e3c43b44f98bbd63ec6ad8\",\n" +
                "                                \"width\": 108\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 216,\n" +
                "                                \"url\": \"https://external-preview.redd.it/wwn0INCPr9KdyzRoLBz3SFsoBlWzUWh8qe8_fmJQ4tM.jpg?width=216&amp;crop=smart&amp;auto=webp&amp;s=6948143f730d8e7193bfca14d1ed80b9b1440516\",\n" +
                "                                \"width\": 216\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"height\": 320,\n" +
                "                                \"url\": \"https://external-preview.redd.it/wwn0INCPr9KdyzRoLBz3SFsoBlWzUWh8qe8_fmJQ4tM.jpg?width=320&amp;crop=smart&amp;auto=webp&amp;s=9bd2d89b430fbaf3896f3101a8d986929028f9ae\",\n" +
                "                                \"width\": 320\n" +
                "                            }\n" +
                "                        ],\n" +
                "                        \"source\": {\n" +
                "                            \"height\": 320,\n" +
                "                            \"url\": \"https://external-preview.redd.it/wwn0INCPr9KdyzRoLBz3SFsoBlWzUWh8qe8_fmJQ4tM.jpg?auto=webp&amp;s=99a56f803583be576fc376531d0163d3a3edd748\",\n" +
                "                            \"width\": 320\n" +
                "                        },\n" +
                "                        \"variants\": {}\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            \"retrieved_on\": 1636902867,\n" +
                "            \"score\": 1,\n" +
                "            \"selftext\": \" Lunar {LNR}: A BSC project with a phenomenal use case and great early  traction. They've been featured in Yahoo! Finance, MarketWatch, Business  Insider, and more! Lunar is streamlining the unnecessarily difficult  process of microcap token trading into a single, frictionless  application. - Revolutionary DEX Wallet App - Daily Passive Rewards for  Holders - KYC-Verified Presale - NFT collection with Passive Earnings -  Great Team &amp; Engaged Community Telegram: https://t.me/lnrDefi  Website: lunardefi.com\",\n" +
                "            \"send_replies\": true,\n" +
                "            \"spoiler\": false,\n" +
                "            \"stickied\": false,\n" +
                "            \"subreddit\": \"lnrDefi\",\n" +
                "            \"subreddit_id\": \"t5_58i432\",\n" +
                "            \"subreddit_subscribers\": 1355,\n" +
                "            \"subreddit_type\": \"public\",\n" +
                "            \"thumbnail\": \"self\",\n" +
                "            \"title\": \"Lunar LNR\",\n" +
                "            \"total_awards_received\": 0,\n" +
                "            \"treatment_tags\": [],\n" +
                "            \"upvote_ratio\": 1.0,\n" +
                "            \"url\": \"https://www.reddit.com/r/lnrDefi/comments/qtru0v/lunar_lnr/\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"all_awardings\": [],\n" +
                "            \"allow_live_comments\": false,\n" +
                "            \"author\": \"Matthewwatson25\",\n" +
                "            \"author_flair_css_class\": null,\n" +
                "            \"author_flair_richtext\": [],\n" +
                "            \"author_flair_text\": null,\n" +
                "            \"author_flair_type\": \"text\",\n" +
                "            \"author_fullname\": \"t2_gfov3c6u\",\n" +
                "            \"author_is_blocked\": false,\n" +
                "            \"author_patreon_flair\": false,\n" +
                "            \"author_premium\": false,\n" +
                "            \"awarders\": [],\n" +
                "            \"can_mod_post\": false,\n" +
                "            \"contest_mode\": false,\n" +
                "            \"created_utc\": 1636902836,\n" +
                "            \"domain\": \"self.Matthewwatson25\",\n" +
                "            \"full_link\": \"https://www.reddit.com/r/u_Matthewwatson25/comments/qtrts6/xpro_web_consulting_get_best_digital_marketing/\",\n" +
                "            \"gildings\": {},\n" +
                "            \"id\": \"qtrts6\",\n" +
                "            \"is_created_from_ads_ui\": false,\n" +
                "            \"is_crosspostable\": true,\n" +
                "            \"is_meta\": false,\n" +
                "            \"is_original_content\": false,\n" +
                "            \"is_reddit_media_domain\": false,\n" +
                "            \"is_robot_indexable\": true,\n" +
                "            \"is_self\": true,\n" +
                "            \"is_video\": false,\n" +
                "            \"link_flair_background_color\": \"\",\n" +
                "            \"link_flair_richtext\": [],\n" +
                "            \"link_flair_text_color\": \"dark\",\n" +
                "            \"link_flair_type\": \"text\",\n" +
                "            \"locked\": false,\n" +
                "            \"media_only\": false,\n" +
                "            \"no_follow\": true,\n" +
                "            \"num_comments\": 0,\n" +
                "            \"num_crossposts\": 0,\n" +
                "            \"over_18\": false,\n" +
                "            \"permalink\": \"/r/u_Matthewwatson25/comments/qtrts6/xpro_web_consulting_get_best_digital_marketing/\",\n" +
                "            \"pinned\": false,\n" +
                "            \"retrieved_on\": 1636902847,\n" +
                "            \"score\": 1,\n" +
                "            \"selftext\": \"X-Pro Web Consulting is the Digital marketing agency, who provides services to business firms like SEO optimization, web development, and web designing. This SEO Company will create a campaign to improve your site's visibility in search engines like Google, Yahoo, and Bing. SEO campaigns will typically involve a combination of on-page optimization, off-page optimization, and link building. The campaigns are designed to bring your site to the top of the search engine results pages for your desired keywords. For more information, visit- [https://x-proweb.com/](https://x-proweb.com/)\",\n" +
                "            \"send_replies\": true,\n" +
                "            \"spoiler\": false,\n" +
                "            \"stickied\": false,\n" +
                "            \"subreddit\": \"u_Matthewwatson25\",\n" +
                "            \"subreddit_id\": \"t5_5bi50b\",\n" +
                "            \"subreddit_subscribers\": 0,\n" +
                "            \"subreddit_type\": \"user\",\n" +
                "            \"suggested_sort\": \"qa\",\n" +
                "            \"thumbnail\": \"self\",\n" +
                "            \"title\": \"X-PRO Web Consulting: Get Best Digital Marketing Agency For Your Business\",\n" +
                "            \"total_awards_received\": 0,\n" +
                "            \"treatment_tags\": [],\n" +
                "            \"upvote_ratio\": 1.0,\n" +
                "            \"url\": \"https://www.reddit.com/r/u_Matthewwatson25/comments/qtrts6/xpro_web_consulting_get_best_digital_marketing/\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        assertNotNull(re.parse(test));
    }
    /**
     * test to getDistW function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void getDistW() {
        RedditExtractor re = new RedditExtractor();
        assertNotNull(re.getDistW("weather",250));
    }
    /**
     * test getsubredditsubmission function
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void partC_getSubredditSubmissions() {
        RedditExtractor re = new RedditExtractor();
        assertNotNull(re.PartC_getSubredditSubmissions("rosin"));
    }
}