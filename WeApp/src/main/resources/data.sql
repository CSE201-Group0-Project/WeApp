INSERT INTO users (id, name, password, username) VALUES
(1, 'Amy Nguyen', '$2a$10$wxy7dVnZDcqqHtpkR6RXaO4n7v6LDIatK8nrHhlbAS0QmmBv0qfom', 'nguyen47'),
(2, 'Xiaocheng Kang', '$2a$10$wxy7dVnZDcqqHtpkR6RXaO4n7v6LDIatK8nrHhlbAS0QmmBv0qfom', 'kangx'),
(3, 'Zhuoyue Sun', '$2a$10$wxy7dVnZDcqqHtpkR6RXaO4n7v6LDIatK8nrHhlbAS0QmmBv0qfom', 'sunz32'); 

INSERT INTO authority (id, authority, user_id) VALUES
(1, 'ROLE_ADMIN', 1),
(2, 'ROLE_USER', 1),
(3, 'ROLE_USER', 2),
(4, 'ROLE_USER', 3),
(5, 'ROLE_MOD', 1),
(6, 'ROLE_MOD', 3),
(7, 'ROLE_ADMIN', 3);

INSERT INTO application (id, approved, category, description, img_src, link, name, organization, platform, price, screenshots, version, user_id) VALUES
(1, 1, 'sms', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/e47wGWp.png', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0, 'https://i.imgur.com/XMz9osB.jpg,https://i.imgur.com/KSUC7ws.jpg,https://i.imgur.com/mcU2Smv.jpg', 'v288.0', 1),
(2, 1, 'video', ' See what the world is watching -- from the hottest music videos to what’s trending in gaming, entertainment, news, and more', 'https://i.imgur.com/6mWTNSp.png', 'https://apps.apple.com/us/app/youtube/id544007664', 'Youtube', 'Google', 'IOS', 0.0, 'https://i.imgur.com/WxRiC3S.jpg,https://i.imgur.com/R2eCsgC.jpg,https://i.imgur.com/dL4Imzx.jpg', 'v15.43.4', 1),
(3, 1, 'sms', 'A popular app in China, you can text, video chat, and share your life in the WeChat', 'https://i.imgur.com/skSLi63.png', 'https://apps.apple.com/us/app/wechat/id414478124', 'WeChat', 'Tencent', 'IOS', 0.0,'', 'v7.0.17', 1),
(4, 1, 'social', 'An app which used worldwidely, you can text, share lives with this app', 'https://i.imgur.com/gqWL7zy.png', 'https://apps.apple.com/us/app/instagram/id389801252', 'Instagram', 'Facebook', 'IOS', 0.0,'', 'v165.0', 1),
(5, 1, 'music', 'An app which can listen to music, MV, and share things to your friends. But it cannot use out of China', 'https://i.imgur.com/3PATcaE.png', 'https://apps.apple.com/cn/app/QQ音乐/id414603431', 'QQMusic', 'Tencent', 'IOS', 0.0,'', 'v8.9', 1),
(6, 1, 'music', 'An app which listen to music, watching MV, and share things to your friends, and it can use out of China', 'https://i.imgur.com/fbBATq9.png', 'https://apps.apple.com/us/app/xiami-music/id595594905', 'XiamiMusic', 'MuzikTec', 'IOS', 0.0,'', 'v8.5.16', 1),
(7, 1, 'social', 'An app which you can text, group chat, video meeting and share lives', 'https://i.imgur.com/jX4dqxi.png', 'https://apps.apple.com/us/app/qq/id444934666', 'QQ', 'Tencent', 'IOS', 0.0,'', 'v8.4.10', 1),
(8, 1, 'video', 'A simple app that you can watch moives, TV shows, sports games and almost everything you want', 'https://i.imgur.com/YyfIeWI.png', 'https://apps.apple.com/us/app/腾讯视频-演员请就位2独播/id458318329', 'TencentVideo', 'Tencent', 'IOS', 0.0,'', 'v8.2.60', 1),
(9, 1, 'shopping', 'A simple app in China to call food delivery, it takes short time and let you have good meals', 'https://i.imgur.com/jxiAq8t.jpg', 'https://apps.apple.com/us/app/美团-美食外卖电影票享优惠/id423084029', 'Shopping', 'SankuaiTec', 'IOS', 0.0,'', 'v11.3.202', 1),
(10, 1, 'social', 'A simple app that let you put things interesting, share interesting things around you', 'https://i.imgur.com/KFHYlhG.png', 'https://apps.apple.com/us/app/facebook/id284882215', 'Facebook', 'Facebook', 'IOS', 0.0,'', 'v294.0', 2),
(11, 1, 'social', 'A simple app that you can see everyone who shared interesting things in their lives', 'https://i.imgur.com/fEAVFAO.png', 'https://apps.apple.com/us/app/tiktok-it-starts-with-you/id835599320', 'TikTok', 'TikTok Pte', 'IOS', 0.0,'', 'v17.8.1', 2),
(12, 1, 'rental', 'A simple app that makes you find hotel or shared house easily, but it might be not safe for someways', 'https://i.imgur.com/u1MLBC4.png', 'https://apps.apple.com/us/app/airbnb/id401626263', 'Airbnb', 'Airbnb', 'IOS', 0.0, '','v20.44', 2),
(13, 1, 'rental', 'A simple app that lets you book a house or hotel in this app, and make the traveling more convenience', 'https://i.imgur.com/gAkjJ6c.png', 'https://apps.apple.com/us/app/booking-com-hotels-travel/id367003839', 'Booking.com', 'Booking', 'IOS', 0.0, '','v25.9.1', 2),
(14, 1, 'news', 'A simple app that lets you watch sports game, see the highlights of the game, and news about things out of game', 'https://i.imgur.com/KVzpm3z.png', 'https://apps.apple.com/us/app/espn-live-sports-scores/id317469184', 'ESPN', 'ESPN', 'IOS', 0.0, '','v6.34', 2),
(15, 1, 'news', 'The BBC News app brings you news from the BBC and our global network of journalists', 'https://i.imgur.com/qZfnGKq.png', 'https://play.google.com/store/apps/details?id=bbc.mobile.news.ww&hl=en_US&gl=US', 'BBC News', 'BBC Studios Limited', 'Android', 0.0, '','v5.16.0', 2),
(16, 1, 'news', 'Discover quality content for all your interests - from personalized news, entertainment, tech and sports articles to trending lifestyle magazines', 'https://i.imgur.com/Zh0hcGa.png', 'https://play.google.com/store/apps/details?id=flipboard.app&hl=en_US&gl=US', 'Flipboard', 'Flipboard', 'Android', 0.0, '','v4.2.55', 2),
(17, 0, 'communication', 'WhatsApp can send and receive messages, calls, photos, videos, documents, and Voice Messages.', 'https://i.imgur.com/pposWbf.png', 'https://play.google.com/store/apps/details?id=com.whatsapp&hl=en_US&gl=US', 'WhatsApp Messenger', 'WhatsApp Inc.', 'Android', 0.0, 'https://i.imgur.com/T3oNV4L.jpg', 'v2.20', 1),
(18, 0, 'communication', 'Discord is your place to talk. Create a home for your communities and friends.', 'https://i.imgur.com/ktVKdeF.png', 'https://play.google.com/store/apps/details?id=com.discord&hl=en_US&gl=US', 'Discord', 'Discord Inc.', 'Android', 0.0, 'https://i.imgur.com/gnYgXu0.jpg', 'v46.3', 2),
(19, 0, 'communication', 'Pure instant messaging — simple, fast, secure, and synced across all your devices.', 'https://i.imgur.com/WAwR6Vp.png', 'https://play.google.com/store/apps/details?id=org.telegram.messenger&hl=en_US&gl=US', 'Telegram', 'Telegram Telegram FZ-LLC', 'Android', 0.0, 'https://i.imgur.com/6sTGozo.jpg', 'v7.2.1', 3),
(20, 0, 'communication', 'Google Chrome is a fast, easy to use, and secure web browser.', 'https://i.imgur.com/J5rTmbW.png', 'https://play.google.com/store/apps/details?id=com.android.chrome&hl=en_US&gl=US', 'Google Chrome', 'Google', 'Android', 0.0, 'https://i.imgur.com/dr0sJmH.jpg', 'v86.0', 3),
(21, 0, 'business', 'Meeting with flawless video and audio, instant screen sharing, and cross-platform instant messaging.', 'https://i.imgur.com/ziI7E15.png', 'https://play.google.com/store/apps/details?id=us.zoom.videomeetings&hl=en_US&gl=US', 'ZOOM Cloud Meetings', 'zoom.us', 'Android', 0.0, 'https://i.imgur.com/ZSDawFB.jpg', 'v5.4.1', 3),
(22, 0, 'social', 'Twitter is your go-to social media app and the source for what is happening in the world.', 'https://i.imgur.com/vfta2zz.png', 'https://play.google.com/store/apps/details?id=com.twitter.android&hl=en_US&gl=US', 'Twitter', 'Twitter Inc.', 'Android', 0.0, 'https://i.imgur.com/7qCq6zs.jpg', 'v8.68', 3),
(23, 0, 'music', 'With Spotify, you can listen to music and play millions of songs and podcasts for free.', 'https://i.imgur.com/sBpetMv.png', 'https://play.google.com/store/apps/details?id=com.spotify.music&hl=en_US&gl=US', 'Spotify', 'Spotify Ltd.', 'Android', 0.0, 'https://i.imgur.com/LZVVHIH.jpg', 'v8.5.83', 3),
(24, 0, 'music', 'YouTube Music is a new music app that allows you to easily find what you’re looking for and discover new music.', 'https://i.imgur.com/7zKumev.png', 'https://play.google.com/store/apps/details?id=com.google.android.apps.youtube.music&hl=en_US&gl=US', 'YouTube Music', 'Google LLC', 'Android', 0.0, 'https://i.imgur.com/Djt19ye.jpg', 'v4.02.52', 3),
(25, 0, 'tools', 'Tired of being tracked online? We can help. At DuckDuckGo, we believe online privacy should be simple.', 'https://i.imgur.com/cw38dwL.png', 'https://play.google.com/store/apps/details?id=com.duckduckgo.mobile.android&hl=en_US&gl=US', 'DuckDuckGo Privacy Browser', 'DuckDuckGo', 'Android', 0.0, 'https://i.imgur.com/W7COvtX.jpg', 'v5.69', 3),
(26, 0, 'tools', 'Translate between 103 languages by typing, photos, conversations and handwriting.', 'https://i.imgur.com/OqT92iy.png', 'https://play.google.com/store/apps/details?id=com.google.android.apps.translate&hl=en_US&gl=US', 'Google Translater', 'Google LLC', 'Android', 0.0, 'https://i.imgur.com/D9ADo7a.jpg', 'v6.13.0.03', 3),
(27, 0, 'education', 'Access your Canvas courses on the go with the Canvas Student mobile app!', 'https://i.imgur.com/B1HsZG4.png', 'https://play.google.com/store/apps/details?id=com.instructure.candroid&hl=en_US&gl=US', 'Canvas Student', 'Instructure', 'Android', 0.0, 'https://i.imgur.com/urY9vCL.jpg', 'v6.9.2', 3),
(28, 0, 'education', 'Canvas Teacher allows teachers to facilitate their courses on the go, both inside and outside the classroom.', 'https://i.imgur.com/DK7ANUT.png', 'https://play.google.com/store/apps/details?id=com.instructure.teacher&hl=en_US&gl=US', 'Canvas Teacher', 'Instructure', 'Android', 0.0, 'https://i.imgur.com/Pa1nic5.jpg', 'v1.11.4', 3),
(29, 0, 'education', 'Canvas Parent is designed to provide visibility into your child education at a glance', 'https://i.imgur.com/cQMAQSl.png', 'https://play.google.com/store/apps/details?id=com.instructure.parentapp&hl=en_US&gl=US', 'Canvas Parent', 'Instructure', 'Android', 0.0, 'https://i.imgur.com/570cbqK.jpg', 'v3.3.0', 3), 
(30, 1, 'photo', 'CamScanner is the best scanner app that will turn your phone into a PDF scanner. Convert images to pdf in a simple tap.', 'https://i.imgur.com/v6YERXZ.png',  'https://apps.apple.com/us/app/camscanner-pdf-scanner-app/id388627783', 'CamScanner', 'Linguan Data', 'IOS', '2.99', 'https://i.imgur.com/IuJdfrK.jpg,https://i.imgur.com/M5d7CRn.jpg,https://i.imgur.com/XvLpZpl.jpg', 'v5.25.3', 3),
(31, 0, "productivity", "​HotSchedules is the industry's leading employee scheduling app because it’s the fastest and easiest way to manage your schedule and communicate with your team", "https://play-lh.googleusercontent.com/cudBRDzsvi50wundWmjnvvaotvejOERDJP4XDur6VtmeiI3aBdGEYmqNVc3Knev5BA=s180-rw", "https://play.google.com/store/apps/details?id=com.tdr3.hs.android&hl=en_US&gl=US", 
"HotSchedules", "HotSchedules", "Android", 2.99, "https://play-lh.googleusercontent.com/fy5RAtDgfH3r_3PD-0cMeafq1MIF067IEeoVGOqoC1zh36edFxxYQBJtiuV7hGQTCEke=w720-h310-rw", "v4.148", 1),
(32, 0, "education", "Experience the excitement of a busy medical center with Toca Life: Hospital!", "https://play-lh.googleusercontent.com/Jeoff_0VjrZ52ou5ghwKoCinaKcOYvWKOASuUNorrhN1nOkBTKn4yqEf0xFViz-3K_L4=s180-rw", "https://play.google.com/store/apps/details?id=com.tocaboca.tocahospital&hl=en_US&gl=US",
"Toca Life: Hospital", "Toca Boca", "Android", 3.99, "https://play-lh.googleusercontent.com/MDzevhV6GL5Isc_9aaKXdfxpik8jOwos9RWlgO29LBf3RfAOX94uC4j-DMWhKlde6Wg=w720-h310-rw", "v1.2", 1),
(33, 0, "arcade", "Explore infinite worlds and build everything from the simplest of homes to the grandest of castles.", "https://play-lh.googleusercontent.com/VSwHQjcAttxsLE47RuS4PqpC4LT7lCoSjE7Hx5AW_yCxtDvcnsHHvm5CTuL5BPN-uRTP=s180-rw", "https://play.google.com/store/apps/details?id=com.mojang.minecraftpe&hl=en_US&gl=US"
"Minecraft", "Mojang", "Android", 6.99, "https://play-lh.googleusercontent.com/0-zBoTxVn5PJQtNNnovURx1JIbIytd7_H8fXbOVNyReZkKdgU30BkBzD-XmdoP6BtS0=w720-h310-rw", "v1.16.40", 1),
(34, 0, "education", "SkyView® is a beautiful and intuitive stargazing app that uses your camera to precisely spot and identify celestial objects in sky, day or night.", "https://play-lh.googleusercontent.com/FbT_XWX5IYXQUt2fWug_vEyOdAWORIBe5ipHETfEvL6QVklVRU0NEFUgMeUN6mM73QY=s180-rw", "https://play.google.com/store/apps/details?id=com.t11.skyview&hl=en_US&gl=US",
"SkyView", "Terminal Eleven", "Android", 1.99, "https://play-lh.googleusercontent.com/FhlzkOZ2penP24R13wzItiEt0Xz1cj4y8BPVAwEaLUl1DPyspc6FBCOxXX-mzcw5f68=w720-h310-rw", "v3.6.3", 1),
(35, 0, "lifestyle", "Necrophonic is an ITC app used for spirit communication and EVP research.", "https://play-lh.googleusercontent.com/aSioghBYlUr13c9ebvwy-zArlTOwZPV8cePQcVXQG5Wy_TD1RewrjxEy4UYdsXj-o-Y=s180-rw", "https://play.google.com/store/apps/details?id=com.chillseekers.Necrophonic&hl=en_US&gl=US"
"Necrophonic", "ChillSeekers", "Android", 9.99, "https://play-lh.googleusercontent.com/EdVTuTsysAPqk2TjgcsNiH3WPrs7aGih5axedagkdG-TX6BPAnVbBGvew2w8o6DFwdE=w720-h310-rw", "v1.16", 1),
(36, 0, "action", "Play as a failed alchemic experiment and explore the sprawling, ever-changing castle to find out what happened on this gloomy island...", "https://play-lh.googleusercontent.com/Mn9NateYFRZQbWnlZvszDPoKZbeuZM2O-Kyn7EKRCZI3D8joecHqytfOx73IyuAwHw=s180-rw", "https://play.google.com/store/apps/details?id=com.playdigious.deadcells.mobile&hl=en_US&gl=US",
"Dead Cells", "Playdigious", "Android", 8.99, "https://play-lh.googleusercontent.com/FFB-FJhscTagOcE4qFjAKqvuT1eGl8z1KkZrnM5b1ks0UDBJ_gtTgtBR4bOejN8oKZ8=w720-h310-rw", "v1.60.6", 1);


INSERT INTO comment(id, content, created_date, application_id, comment_id, user_id) VALUES
(1, 'This is an awesome app', '2020-11-10 10:00:00', 1, null, 1), 
(2, 'I agree!', '2020-11-10 10:10:10', 1, 1, 2),
(3, 'Me too!', '2020-11-10 10:10:12', 1, 2, 3),
(4, 'Love from Vietnam', '2020-11-10 11:00:00', 1, null, 1),
(5, 'Hello from China!', '2020-11-10 11:10:10', 1, 4, 2);