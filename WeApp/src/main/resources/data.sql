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
(5, 0, 'music', 'An app which can listen to music, MV, and share things to your friends', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/cn/app/QQMusic/id414603431', 'QQMusic', 'Tencent', 'IOS', 0.0,'', 'v8.9', 1),
(6, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0,'', 'v288.0', 1),
(7, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0,'', 'v288.0', 1),
(8, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0,'', 'v288.0', 1),
(9, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0,'', 'v288.0', 1),
(10, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0,'', 'v288.0', 1),
(11, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0,'', 'v288.0', 1),
(12, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0, '','v288.0', 1),
(13, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0, '','v288.0', 1),
(14, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0, '','v288.0', 1),
(15, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0, '','v288.0', 1),
(16, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0, '','v288.0', 1),
(17, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0, '','v288.0', 1),
(18, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0, '','v288.0', 1),
(19, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0, '','v288.0', 1),
(20, 0, 'messaging', 'A simple app that lets you text, video chat, and stay close with people you care about', 'https://i.imgur.com/AEZ56Xw.jpg', 'https://apps.apple.com/us/app/messenger/id454638411', 'Messenger', 'Facebook', 'IOS', 0.0, '','v288.0', 1);

