INSERT INTO users (id, name, password, username) VALUES
(1, 'Amy Nguyen', '$2a$10$wxy7dVnZDcqqHtpkR6RXaO4n7v6LDIatK8nrHhlbAS0QmmBv0qfom', 'aestheteeism');

INSERT INTO authority (id, authority, user_id) VALUES
(1, 'ROLE_ADMIN', 1),
(2, 'ROLE_USER', 1);

INSERT INTO application (id, approved, category, description, img_src, link, name, organization, platform, price, screenshots, version, user_id) VALUES
(1, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/e47wGWp.png', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0, 'https://i.imgur.com/XMz9osB.jpg,https://i.imgur.com/KSUC7ws.jpg,https://i.imgur.com/mcU2Smv.jpg', 'v288.0', 1),
(2, 0, 'video', ' See what the world is watching -- from the hottest music videos to what’s trending in gaming, entertainment, news, and more', 'https://i.imgur.com/6mWTNSp.png', 'https://apps.apple.com/us/app/youtube/id544007664', 'Youtube', 'Google', 'IOS', 0.0, 'https://i.imgur.com/WxRiC3S.jpg,https://i.imgur.com/R2eCsgC.jpg,https://i.imgur.com/dL4Imzx.jpg', 'v15.43.4', 1),
(3, 0, 'messaging', 'A popular app in China, you can text, video chat, and share your life in the WeChat', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/wechat/id414478124', 'WeChat', 'Tencent', 'IOS', 0.0,'', 'v7.0.17', 1),
(4, 0, 'social', 'An app which used worldwidely, you can text, share lives with this app', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/instagram/id389801252', 'Instagram', 'Facebook', 'IOS', 0.0,'', 'v165.0', 1),
(5, 0, 'music', 'An app which can listen to music, MV, and share things to your friends. But it cannot use out of China', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/cn/app/QQ音乐/id414603431', 'QQMusic', 'Tencent', 'IOS', 0.0,'', 'v8.9', 1),
(6, 0, 'music', 'An app which listen to music, watching MV, and share things to your friends, and it can use out of China', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/xiami-music/id595594905', 'XiamiMusic', 'MuzikTec', 'IOS', 0.0,'', 'v8.5.16', 1),
(7, 0, 'social', 'An app which you can text, group chat, video meeting and share lives', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/qq/id444934666', 'QQ', 'Tencent', 'IOS', 0.0,'', 'v8.4.10', 1),
(8, 0, 'video', 'A simple app that you can watch moives, TV shows, sports games and almost everything you want', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/腾讯视频-演员请就位2独播/id458318329', 'TencentVideo', 'Tencent', 'IOS', 0.0,'', 'v8.2.60', 1),
(9, 0, 'shopping', 'A simple app in China to call food delivery, it takes short time and let you have good meals', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/美团-美食外卖电影票享优惠/id423084029', 'Shopping', 'SankuaiTec', 'IOS', 0.0,'', 'v11.3.202', 1),
(10, 0, 'social', 'A simple app that let you put things intersting, share interesting things around you', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/facebook/id284882215', 'Facebook', 'Facebook', 'IOS', 0.0,'', 'v294.0', 1),
(11, 0, 'Entertainment', 'A simple app that you can see everyone who shared interesting things in their lives', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/tiktok-it-starts-with-you/id835599320', 'TikTok', 'TikTok Pte', 'IOS', 0.0,'', 'v17.8.1', 1),
(12, 0, 'Rental', 'A simple app that makes you find hotel or shared house easily, but it might be not safe for someways', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/airbnb/id401626263', 'Airbnb', 'Airbnb', 'IOS', 0.0, '','v20.44', 1),
(13, 0, 'Rental', 'A simple app that lets you book a house or hotel in this app, and make the traveling more convenience', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/booking-com-hotels-travel/id367003839', 'Booking.com', 'Booking', 'IOS', 0.0, '','v25.9.1', 1),
(14, 0, 'news', 'A simple app that lets you watch sports game, see the highlights of the game, and news about things out of game', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/espn-live-sports-scores/id317469184', 'ESPN', 'ESPN', 'IOS', 0.0, '','v6.34', 1),
(15, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0, '','v288.0', 1),
(16, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0, '','v288.0', 1),
(17, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0, '','v288.0', 1),
(18, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0, '','v288.0', 1),
(19, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0, '','v288.0', 1),
(20, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0, '','v288.0', 1);

