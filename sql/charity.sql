/*
Navicat MySQL Data Transfer

Source Server         : Mhou
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : charity

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2020-08-11 07:51:49
*/

Drop database Charity;

Create database Charity; 

Use Charity;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for award
-- ----------------------------
DROP TABLE IF EXISTS `award`;
CREATE TABLE `award` (
  `Aid` int(11) NOT NULL AUTO_INCREMENT,
  `Aname` varchar(20) DEFAULT NULL,
  `Auid` int(11) DEFAULT NULL,
  `Atime` date DEFAULT NULL,
  `Acomment` text,
  PRIMARY KEY (`Aid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of award
-- ----------------------------
INSERT INTO `award` VALUES ('1', '测试bug冠军', '23', '2020-03-18', '我曾踏足山巅，也曾掉入低谷，二者都让我受益良多');
INSERT INTO `award` VALUES ('2', '爱心公益大使', '24', '2020-05-03', '勿以善小而不为');
INSERT INTO `award` VALUES ('3', '平台大师', '33', '2020-05-08', '希望可以帮助每一个人。');

-- ----------------------------
-- Table structure for cabinet
-- ----------------------------
DROP TABLE IF EXISTS `cabinet`;
CREATE TABLE `cabinet` (
  `Cid` int(11) NOT NULL AUTO_INCREMENT,
  `Caddress` varchar(100) DEFAULT NULL,
  `Cname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Cid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='关于公益柜的信息';

-- ----------------------------
-- Records of cabinet
-- ----------------------------
INSERT INTO `cabinet` VALUES ('1', '北京市辖区东城区北京市辖区东城区北京路18号', '北京CBD');
INSERT INTO `cabinet` VALUES ('2', '上海市辖区徐汇区中山街68号', '暖心公益');
INSERT INTO `cabinet` VALUES ('3', '广东茂名市高州市中山路68号', '茂名慈善');
INSERT INTO `cabinet` VALUES ('4', '重庆市辖区大渡口区人民广场', '重庆火锅');
INSERT INTO `cabinet` VALUES ('5', '四川成都市金牛区和品路168号', '四川盆地');
INSERT INTO `cabinet` VALUES ('6', '云南丽江市古城区桂林山水36巷', '云贵高原');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `Cid` int(11) NOT NULL AUTO_INCREMENT,
  `Comment` varchar(255) DEFAULT NULL,
  `Cnid` int(20) DEFAULT NULL,
  `Cuid` int(20) DEFAULT NULL,
  `Capply` varchar(255) DEFAULT NULL,
  `Ctime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Cflag` int(11) DEFAULT NULL,
  `Caboy` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Cid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('3', '摇晃在 无垠的星海\r\n\r\n分不清 是水或天上', '0', '33', null, '2020-03-20 00:00:00', '0', null);
INSERT INTO `comment` VALUES ('4', '如果你还听见我 漫长的倾诉\r\n\r\n是我为你拥抱的海洋\r\n\r\n别告诉我 你要去哪', '0', '24', null, '2020-03-30 00:00:00', '0', null);
INSERT INTO `comment` VALUES ('5', '别告诉我 你要去哪\r\n\r\n因为永远 我会知道你方向', '0', '23', null, '2020-03-30 17:15:59', '0', null);
INSERT INTO `comment` VALUES ('6', '几片浮云 整夜星空 指引你我 唯一的远方\r\n\r\n带你前往 等你仰望 整夜星空 是为你闪亮', '0', '24', '船', '2020-04-01 23:07:12', '1', 'Mhou');
INSERT INTO `comment` VALUES ('7', '这船是我 最深愿望\r\n\r\n这片星空 是你的模样', '0', '27', '林宥嘉', '2020-04-01 23:05:30', '1', 'Mhou');
INSERT INTO `comment` VALUES ('8', 'hello', '21', '23', null, '2020-04-04 23:16:21', '0', null);
INSERT INTO `comment` VALUES ('20', '测试过', '15', '23', null, '2020-04-06 06:46:24', '0', null);
INSERT INTO `comment` VALUES ('21', '沉默是一条孤独的鱼', '0', '38', null, '2020-05-09 09:48:37', '0', null);

-- ----------------------------
-- Table structure for donation
-- ----------------------------
DROP TABLE IF EXISTS `donation`;
CREATE TABLE `donation` (
  `Did` int(11) NOT NULL AUTO_INCREMENT,
  `Duid` int(11) DEFAULT NULL,
  `Dmoney` int(255) DEFAULT NULL,
  `Donations` varchar(50) DEFAULT NULL,
  `Daddress` varchar(20) DEFAULT NULL,
  `Dnid` int(11) DEFAULT NULL,
  `Dsid` int(11) DEFAULT NULL,
  PRIMARY KEY (`Did`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='捐赠物品和钱款表';

-- ----------------------------
-- Records of donation
-- ----------------------------
INSERT INTO `donation` VALUES ('11', '23', '100000', '10000个口罩', '支援武汉', null, '11');
INSERT INTO `donation` VALUES ('12', '23', '10000', '5000套防护服', '支援武汉', null, '12');
INSERT INTO `donation` VALUES ('13', '24', '1000', '捐赠1000元', '扶贫项目', '6', '13');
INSERT INTO `donation` VALUES ('14', '33', '10000', '捐赠10000元', '无私的爱', '5', '14');
INSERT INTO `donation` VALUES ('15', '25', null, '捐赠500个书包', '扶贫项目', '6', '15');
INSERT INTO `donation` VALUES ('16', null, '10000', '捐赠10000.00元', '平台捐款', '0', null);
INSERT INTO `donation` VALUES ('17', null, '12500', '捐赠12500.00元', '为了孩子', '17', null);
INSERT INTO `donation` VALUES ('18', null, '12000', '捐赠12000.00元', '为了孩子', '17', null);
INSERT INTO `donation` VALUES ('19', null, '12365', '捐赠12365.00元', '扶持贫困家庭', '16', null);
INSERT INTO `donation` VALUES ('20', '23', '100', '捐赠100.00元', '为了孩子', '17', null);
INSERT INTO `donation` VALUES ('21', '28', '100', '捐赠100.00元', '为了孩子', '17', null);
INSERT INTO `donation` VALUES ('22', null, '50000', '捐赠50000.00元', '为了孩子', '17', null);
INSERT INTO `donation` VALUES ('23', null, '10000', '捐赠10000.00元', '生命，邂逅一份淡然', '3', null);
INSERT INTO `donation` VALUES ('24', '23', '50000', '捐赠50000.00元', '她们的身后不再是一个人', '22', null);

-- ----------------------------
-- Table structure for email
-- ----------------------------
DROP TABLE IF EXISTS `email`;
CREATE TABLE `email` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `Eusername` varchar(25) DEFAULT NULL,
  `Emess` text,
  `Esubject` varchar(255) DEFAULT NULL,
  `Etime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `EsendUser` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of email
-- ----------------------------
INSERT INTO `email` VALUES ('1', '1299484739@qq.com', '慧', '肥婆肥臀臀', '肥婆', '2020-04-25 00:07:57', 'Ruan');
INSERT INTO `email` VALUES ('2', '1063493030@qq.com', 'Mhou', '成功', '测试连线', '2020-04-24 23:00:37', 'Mhou');
INSERT INTO `email` VALUES ('3', '1063493030@qq.com', 'Mhou', '明天9:30准时来公司上班！', '准时来上班', '2020-04-24 15:47:57', 'Mhou');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `Mid` int(11) NOT NULL AUTO_INCREMENT,
  `Mname` varchar(20) DEFAULT NULL,
  `Mess` text,
  `Mtime` datetime DEFAULT NULL,
  `Mapply` text,
  `Mflag` int(11) DEFAULT NULL,
  `Mtitle` varchar(20) DEFAULT NULL,
  `Mcheckboy` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Mid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='关于留言和评论的表';

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', 'Jie', '<p>谢谢你</p>', '2020-04-26 08:20:26', null, '0', '可以帮我一下吗', null);
INSERT INTO `message` VALUES ('2', 'Mhou', '<p>hello</p>', '2020-04-26 18:30:47', null, '0', 'hello', null);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `Nid` int(11) NOT NULL AUTO_INCREMENT,
  `Ntitle` varchar(50) DEFAULT NULL,
  `Ncheckboy` varchar(20) DEFAULT NULL,
  `Narticle` text,
  `Ntime` datetime DEFAULT NULL,
  `Nflag` int(11) DEFAULT NULL,
  `Nauthor` varchar(20) DEFAULT NULL,
  `Nmoney` int(255) DEFAULT NULL,
  `Ncause` text,
  `Nselect` int(11) DEFAULT NULL,
  `Nimage` varchar(100) DEFAULT NULL,
  `Money` int(255) DEFAULT NULL,
  `Nintro` text,
  PRIMARY KEY (`Nid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='写关于慈善项目和平台最近活动的表';

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('3', '生命，邂逅一份淡然', 'Mhou', '<span><span><p>&nbsp;&nbsp;&nbsp;&nbsp;做一个<a href=\"http://www.duwenzhang.com/huati/kuaile/index1.html\" target=\"_blank\">快乐</a>的人，做一个心中有梦的人，因为有梦<a href=\"http://www.duwenzhang.com/wenzhang/shenghuosuibi/\" target=\"_blank\">生活</a>才会狂奔，因为有梦<a href=\"http://www.duwenzhang.com/huati/shengming/index1.html\" target=\"_blank\">生命</a>才不会沉沦，与<a href=\"http://www.duwenzhang.com/huati/mengxiang/index1.html\" target=\"_blank\">梦想</a>同行，总会有惊讶眸光的<a href=\"http://www.duwenzhang.com/huati/gandong/index1.html\" target=\"_blank\">感动</a>。天空总是博<a href=\"http://www.duwenzhang.com/huati/aixin/index1.html\" target=\"_blank\">爱心</a>生羽翼的人，大地总是宠爱心怀四季的人，与天地同行，就会沾染山水的灵秀。行于红尘莫问秋月几时寒，一心向阳，不言冷暖；七彩<a href=\"http://www.duwenzhang.com/wenzhang/renshengzheli/\" target=\"_blank\">人生</a>风云多变，守一份情怀，不叹沧桑几番。吟一曲欢歌奏响纯情，释怀岁月。植一束心花泼洒温润，笑语流年。</p><p>　　人之所以不愉快，是面对繁杂难以掌控自己的心，寄托的太多，被忧虑所扰，走不出飘渺的思维，被情绪左右，被纠结缠绕。生存需要踏出脚窝的印痕，而不是寻找<a href=\"http://www.duwenzhang.com/huati/linghun/index1.html\" target=\"_blank\">灵魂</a>的依附。放下纠葛是为了理清脉络，坦荡风雨是为了明辨自我。放下不是不问世事立地成佛，而是便于更多的融入，找回生存的<a href=\"http://www.duwenzhang.com/huati/jiazhi/index1.html\" target=\"_blank\">价值</a>观。任何时候都不要卑微自己的心，不傲驯与人，也不委求与人。<a href=\"http://www.duwenzhang.com/huati/zuoren/index1.html\" target=\"_blank\">做人</a>可以不出色，但不能丢失本色，活出自我才是生存的原则。</p><p>　　对生命好一点，对生活<a href=\"http://www.duwenzhang.com/huati/kuanrong/index1.html\" target=\"_blank\">宽容</a>点，现在抱怨的所有不满，都是多年以后的留恋。岁月每天都在老去，不要把困惑装在心里，多给时光一点喘息的机会。有生命就有艰难险阻，有生活就有磕磕绊绊，季节的更迭调配着生活的色调，风风雨雨润泽旅途的多彩。一句珍重一份感动，一份<a href=\"http://www.duwenzhang.com/huati/zhenxi/index1.html\" target=\"_blank\">珍惜</a>一份丰盈，快乐是能有人同行风雨，<a href=\"http://www.duwenzhang.com/huati/xingfu/index1.html\" target=\"_blank\">幸福</a>是有个人陪着一起老去，珍爱<a href=\"http://www.duwenzhang.com/huati/yongyou/index1.html\" target=\"_blank\">拥有</a>，珍爱生活的点滴。</p><p>　　人生靠一份缘相遇，靠一份心随情。长久的接触，难免的磕碰，因为在乎所以纠葛，谁对谁错又怎能分得清？相识容易相守难，错综复杂的人生，又有几人真正悟透人情？转身只一念，回首已茫然。错落风尘难免有太多凌乱，潇潇风雨夹杂着俗世的冷寒。情浓厚如山，情去薄如纸。山水轮流转，人去缘尽难再还。自古春风暖花语，谁解流水落花两无言？人生不容易，多一份理解心自宽，多一份谦让两安然。</p><p>　　给生命一个<a href=\"http://www.duwenzhang.com/huati/kaixin/index1.html\" target=\"_blank\">开心</a>的理由，不做生命的负累。一个人可以不特别，但尽量唯一，生命是自己的，<a href=\"http://www.duwenzhang.com/wenzhang/xinqingriji/\" target=\"_blank\">心情</a>也是自己的，旅途匆匆，不被琐碎掌控，不拿心情做无谓的陪葬品，走一程无悔活出自我。世俗繁杂，冷暖多变，很多事情不是不在乎，而是有更多的事要做，没有那么多的精力站在原地纠结。路每天都在走，而我们真正走的不是路，熬费的而是人生。时光不会等人，岁月我们也挥霍不起。走一路风尘，只要无愧于己，不拖累他人，足矣。</p><p><img src=\"/static/uploadfiles/1585451329636_IDcard.jpg\" style=\"max-width:100%;\"></p></span><p><br></p></span><p><br></p>', '2020-03-29 03:13:07', '1', 'Mhou', '10000', '', '2', '/static/uploadfiles/1585451329636_IDcard.jpg', '100000', null);
INSERT INTO `notice` VALUES ('4', '救援', 'Mhou', '<span><p>&nbsp;&nbsp;父亲的救援　　　　张铭书　　　　(1)1992年，我在地区高师读书，父母亲在老家种田。父亲为贴补家用，不顾多年腰疼的老毛病，农忙之余帮人跑起了长途货运。这年父亲已46岁。　　　　(2)正是这年，出了一件大事，父亲至今还清晰地记得当时所有的细节。　　　　(3)那天正好是寒露，阴历的八月二十九。（Ａ）天黑且下着雨的时候，父亲从外地跑车回来，刚一进村，就看见村支书迎头挡在车灯前面，朝父亲一个劲儿地摆手。父亲赶紧刹车。支书一脸焦急地说：“快！你娃出事了！”原来他刚刚从电视里插播的紧急通告里看到：一个20岁左右的小伙，在本市遭遇车祸，被紧急送往市一院，司机已逃逸，小伙身上只找出一些零钱，另有一本学生证，望家人紧急联系。学生证上写着我的名字，所以支书便急吼吼地来找我父亲。　　　　(4)父亲的脸迅速变得煞白，他蹲在车下先抽了两分钟烟，然后抬头问支书：“你家里还有多少钱？”支书说：“也不太多。”父亲说：“有多少拿多少吧。”幸好父亲身上还装着代收的几千元货款。　　　　(5)父亲不敢让我母亲知道，家也没回，当即发动车，准备直奔市一院。车开到镇子上，不敢再开了，因为手抖得太厉害。就从街上找到他的一名老战友，帮忙驾车直扑市里。从小镇到市区仅八十公里，一个小时后就到了。　　　　(6)主治医生马上催他火速往住院部缴钱：“伤情非常严重，需立即手术，如果再晚几个小时联系不到家人，双腿将很难保住。”　　　　(7)父亲再也隐忍不住，眼泪哗一下倾倒了满脸。他跌跌撞撞地赶紧往缴费处跑。　　　　(8)从缴费处回来，不顾护士的拦阻，硬闯进急诊室。　　　　(9)父亲看到的是一张清秀的面容。人已昏迷过去。父亲的心里“咯噔”一下，因为他发现这个小伙并非他儿子——也就是说，并不是我。父亲从里面退出来，反复端详从小伙身上找出的那张学生证，学生证上的照片和名字都是我的，没有错呀。父亲迷惑了。www.lizhidaren.com　　　　(10)这时来了几名警察，警察告诉父亲，这个小伙的身份刚刚弄清了，原来是一名小偷，刚刚在公交车上偷了几个学生，被人发觉后，就跳车狂奔，他做贼心虚，已经把所有追赶的人都甩掉了，还是不停地飞跑，结果就跑到了一个车轱辘上。　　　　(11)父亲这才松了一口气。整个人虚脱得一身大汗，瘫坐在门口的石头台阶上，再也站不起来。　　　　(12)这时，父亲的战友提醒道：“病人不是你儿子，你缴的住院押金怎么办？”　　　　(13)父亲说：“当然要退了，他偷了我儿子，还害得差点吓死我，哪能再给他白扔钱？”　　　　(14)父亲就到收费处去退钱。收费处让父亲找主治医生开退费说明。又去找主治医生，主治医生刷刷几笔就开好了。　　　　(15)父亲却犹豫起来，说，算了，这钱我不退了，你们接着给他治吧，长得那么漂亮的小伙子，要是少了两条腿多可惜呀，他家里应该也有父母，他的父母也一定会疼得心慌。　　　　(16)小伙的手术顺利进行。　　　　(17) 此时已是深夜，父亲想来学校找我，又怕打搅我睡觉，就和战友在车里胡乱挤了一宿，第二日早上才来学校，看见我后，冲上来紧紧抱了我一下。父亲一贯性格刚强，平时很少流露感情，这次拥抱，还是我有记忆以来的第一次。　　　　(18)那小伙在医院的精心治疗下，恢复得很好。（Ｂ）小伙子出院的那天，阳光灿烂。他寻到我家，给我父亲磕了仨响头，非要认我父亲为干爹。　　　　(19)我父亲担心他再学坏，就让他跟自己学开车。　　　　(20) &nbsp;现在，十多年过去了，他已成为本市运输业非常叫得响的一位老板,去年,还被市里评为“2006年度最具爱心十大人物”之一。 这篇关于<strong>父亲的救援</strong>的文章,11i到此已经介绍完了,希望对你有所帮助。<br>11i部分文章为网络转载,部分出处不明,如果有相关文章无意侵犯阁下之权益,希望来信说明!</p><p><img src=\"/static/uploadfiles/1585455061927_IDcard.jpg\" style=\"max-width:100%;\"></p></span><p><br></p>', '2020-03-29 04:08:35', '1', 'Mhou', '0', '', '1', '/static/uploadfiles/1585455061927_IDcard.jpg', '1000000', null);
INSERT INTO `notice` VALUES ('5', '无私的爱', 'Mhou', '<p>在土耳其旅游途中，巴士行经1999年大地震的地方，导游讲述了一个感人而且令人悲伤的故事，故事发生在地震后的第二天……&nbsp;<br><br>　　地震后，许多房子都倒塌了，各国来的救援人员不断搜寻着可能的生还者。&nbsp;<br><br>　　两天后，他们在废墟中看到一个令人难以置信的画面——一位母亲，用手撑地，背上顶着不知有多重的石块。一看到救援人员，她便拼命哭喊：“快点救我的女儿，我已经撑了两天，我快撑不下去了……”&nbsp;<br><br>　　她7岁的小女儿，就躺在她用手撑起的安全空间里。&nbsp;<br><br>　　救援人员大惊，他们卖力地搬移周围的石块，希望尽快解救这对母女。但是石块那么多，那么重，他们始终无法快速到达她们身边。&nbsp;<br><br>　　媒体记者到这儿拍下画面，救援人员一边哭、一边挖，辛苦的母亲则苦撑着、等待着……&nbsp;<br><br>　　看着电视上的画面和报纸上的图片，土耳其人都心酸得掉下泪来。&nbsp;<br><br>　　更多的人纷纷放下手边的工作投入救援行动。&nbsp;<br><br>　　救援行动从白天进行到深夜，终于，一名高大的救援人员够着了小女孩，将她拉了出来，但是……她已气绝多时。&nbsp;<br><br>　　母亲急切地问：“我的女儿还活着吗？”&nbsp;<br><br>　　以为女儿还活着，是她苦撑两天唯一的理由和希望。&nbsp;<br><br>　　这名救援人员终于受不了了，他放声大哭：“对，她还活着，我们现在要把她送到医院急救，然后也要把你送过去！”&nbsp;<br><br>　　他知道，如果母亲听到女儿已死去，必定失去求生的意志，松手让土石压死自己，所以骗了她。&nbsp;<br><br>　　母亲疲惫地笑了，随后，她也被救出送到医院，她的双手一度僵直无法弯曲。&nbsp;<br><br>　　第二天，土耳其很多报纸上都有一幅她用手撑地的照片，标题是：《这就是母爱》。&nbsp;<br><br>　　导游说：“我是个不轻易动感情的人，但是看到这篇报道，我哭了。以后每次带团经过这儿，我都会讲这个故事。”&nbsp;<br><br>　　其实不止他哭了，在车上的我们，也哭了……\n\n</p><p><img src=\"/static/uploadfiles/1585455853179_IDcard.jpg\" style=\"max-width:100%;\"></p>', '2020-03-29 04:10:04', '1', 'Mhou', '0', '', '1', '/static/uploadfiles/1585455853179_IDcard.jpg', '1000000', null);
INSERT INTO `notice` VALUES ('6', '扶贫项目', 'Mhou', '<span><p>&nbsp;&nbsp;&nbsp;&nbsp;为帮助湘西贫困山区儿童温暖过冬、顺利求学，12月21日下午14：00，由小猪班纳、英氏、安奈儿、皮偌乔、moomoo、贝贝帕克、牧童、snoopy、木木屋共9家知名童装品牌联合“国民村长”李锐共同发起“聚爱童行”的公益活动——“聚爱童行之公益大冲关”，该活动将在广州长隆野生动物园举办。届时，湖南卫视著名主持人“村长”李锐将在现场直播助阵，通过天猫直播平台与网友实时互动，线上线下暖心助力捐赠。 关爱贫困山区儿童 众品牌商携手做公益 聚爱童行 12月初，我们的志愿者团队驱车前往湘西土家族苗族自治州龙山县第一小学，并对该校多位贫困儿童进行了探访，深入了解他们的家庭状况。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;该县为国家扶贫政策重点关注的的贫困地区之一，当地留守儿童较多。他们父母常年在外打工，家中经济状况堪忧。不少儿童甚至面临失学问题。 在了解到该县贫困儿童现状及捐助需求后，“村长”李锐，联合9家童装品牌联合发起了本次“聚爱童行之公益大冲关”活动，旨在通过线上线下联动公益活动，吸引社会爱心人士关注，共同为贫困儿童捐赠过冬物资、募集助学善款。 直播互动+公益众筹 线上线下暖心助力 据了解，该公益暖心助力捐赠计划已于日前全面启动，各项筹备工作正有序进行。在即将于12月21日举办的长隆野生动物园“聚爱童行公益大冲关”活动中，“村长”李锐将带领几位来自湘西龙山县的儿童开启智勇冲关挑战，在游戏中为贫困儿童筹集公益捐助。 12月21日活动当天下午14：00，所有参与本次公益活动的品牌商还将举行现场捐赠仪式。而且，该活动还将通过天猫直播平台与网友实时互动。直播过程中，线上粉丝赠送的所有“礼物”都将以物资的形式捐赠给贫困儿童。 在该项计划中，除线下公益大冲关及直播捐赠活动之外，聚划算平台也将联合多家童装品牌发起线上公益众筹。所有参与活动的品牌商在聚划算平台每卖出一件衣服，即捐赠一元助学善款，通过人人公益的力量，助力贫困山区儿童改善经济状况，实现求学成才梦。<br><img src=\"/static/uploadfiles/1585455674273_IDcard.jpg\" style=\"max-width:100%;\"></p></span><p><br></p>', '2020-03-29 04:15:22', '1', 'Jie', '1000', '', '1', '/static/uploadfiles/1585455674273_IDcard.jpg', '1000000', null);
INSERT INTO `notice` VALUES ('9', '宝贝计划', 'Mhou', '<span><p>&nbsp;&nbsp;&nbsp;&nbsp;13个省区近10万余贫困婴幼儿家庭受益 2016年7月28日，贝因美与爱同行公益项目启动暨物资发放仪式在甘肃省定西市举行。中国妇女发展基金会副秘书长张建岷、甘肃省妇联副主席张新兰、贝因美婴童食品有限公司西二区营销总监贾志伸等出席了活动。 贝因美与爱同行公益项目以帮助贫困婴幼儿家庭、孕产妇家庭为宗旨，积极开展“爱婴”“育婴”“亲母”三大主题活动，以实际行动传播“爱”的精神，倡导母乳喂养理念，护佑母婴健康，关注特殊困难婴童的健康成长。募集的物资资金主要为贫困婴幼儿家庭提供救助。&nbsp;</p><p>&nbsp;&nbsp;&nbsp;&nbsp;贝因美婴童食品有限公司自2012年就持续关注妇幼健康，连续5年向中国妇女发展基金会捐赠物资及资金高达5000余万元。仅2016年，贝因美及其代理商就捐赠物资及资金3093.2996万元，物资覆盖内蒙古、甘肃、贵州、四川等中西部13个省区市的100余个市(县区)，主要为婴幼儿奶粉，预计10万余户贫困婴幼儿家庭和孕产妇家庭。 活动上，中国妇女发展基金会副秘书长张建岷表达了对贝因美及所有关心妇女公益慈善事业的社会各界爱心人士的感谢，她指出，母婴健康一直是妇基会的中心任务之一，母婴健康状况反映社会人群的整体健康水平，反映整个国家的政治、经济、文化的整体水平。为进一步帮扶贫困婴幼儿家庭、孕产妇家庭，使婴幼儿在发育关键期能及时、充足的获取营养，保证智力和身体正常发育，享有良好的生存质量，中国妇女发展基金会将与贝因美等所有关爱女性公益慈善事业的各界爱心人士一道，把提高妇幼健康水平作为长期努力的方向，她承诺中国妇女发展基金会将与各级妇联严格执行发放标准，组织好，落实好，把物资发放到最需要的贫困家庭手中，把企业爱心准确传递。 此次爱心物资的捐赠对象是在甘肃省定西市各村上报的低保户、贫困户，经基层妇联工作人员挨家挨户实地调查摸底、筛选出来的。捐赠活动获得了广大育龄妇女的一致好评，更好地拉近了育龄群众与妇联工作者之间的距离。同时，“母亲健康快车”还将对物资进行部分发放，对准妈妈进行产前检查，让贫困妈妈感受到社会关爱之情。发放现场群众的脸上洋溢着满意的微笑，心中更是暖暖的。</p></span><p><img src=\"/static/uploadfiles/1585737416880_IDcard.jpg\" style=\"max-width:100%;\"></p>', '2020-04-01 10:29:16', '1', 'Mhou', '0', '', '2', '/static/uploadfiles/1585737416880_IDcard.jpg', '100000', null);
INSERT INTO `notice` VALUES ('10', '急需寻找“张小四”', 'Mhou', '<p>与父亲走散&nbsp;<img src=\"/static/uploadfiles/1585456683766_IDcard.jpg\" style=\"max-width: 100%;\"></p>', '2020-03-29 04:29:42', '1', 'Mhou', '0', null, '3', '/static/uploadfiles/1585456683766_IDcard.jpg', '0', null);
INSERT INTO `notice` VALUES ('11', '关爱留守儿童', 'Mhou', '<p>在<a href=\"http://www.duwenzhang.com/huati/shehui/index1.html\">社会</a>中，有许多这样的<a href=\"http://www.duwenzhang.com/huati/haizi/index1.html\">孩子</a>们。</p><p>　　<a href=\"http://www.duwenzhang.com/huati/fumu/index1.html\">父母</a>外出打工，留下了年仅只有几岁的孩子支撑<a href=\"http://www.duwenzhang.com/huati/jiating/index1.html\">家庭</a>，一走就是几年，父母回来时，孩子们高兴得不得了，可当父母<a href=\"http://www.duwenzhang.com/huati/libie/index1.html\">离别</a>时，孩子们，抑制不住情绪，追着摩托车跑出去，直至父母的身影消失。</p><p>　　 这就是留守儿童的<a href=\"http://www.duwenzhang.com/wenzhang/shenghuosuibi/\">生活</a>，虽然我没有经历过，但看着他们，作为<a href=\"http://www.duwenzhang.com/huati/xingfu/index1.html\">幸福</a>，有父母陪在身边的我们比起来，真的比不过他们的懂事与<a href=\"http://www.duwenzhang.com/wenzhang/shenghuosuibi/chengzhang/\">成长</a>。</p><p>　　 每天，照顾着家里年迈的<a href=\"http://www.duwenzhang.com/huati/yeye/index1.html\">爷爷</a><a href=\"http://www.duwenzhang.com/huati/nainai/index1.html\">奶奶</a>，做饭，洗衣服，烧水，砍柴，比起我们赋予的家庭，真的觉得挺难受的，原以为，我们可以过得比他们好，还有些歧视，但真正地，慢慢的再回头看时，作为我们这些富裕家庭的孩子比起来，真的连他们都不如。</p><p><img src=\"/static/uploadfiles/1585736774312_IDcard.jpg\" style=\"max-width:100%;\"></p><p>　　 每天早早起来，为年迈的爷爷奶奶烧水洗脸，然后去上学，中午回家，为他们做饭，这些本是他们父母做的，可他们的父母<a href=\"http://www.duwenzhang.com/huati/likai/index1.html\">离开</a>家里，去了外地辛苦的打工，家里的重担，就落在了年仅几岁的孩子身上。</p><p>　　 作为富裕家庭的我们，感到很幸福，可他们呢，一边想着早点见到自己的父母，一边又要做家里的所有家务活，我们富裕家庭孩子们幸福了，他们的幸福呢。</p><p>　　 记得我曾经看见过一个新闻，一个小<a href=\"http://www.duwenzhang.com/huati/nvhai/index1.html\">女孩</a>的<a href=\"http://www.duwenzhang.com/huati/muqin/index1.html\">妈妈</a>从外地回家了，但只能住一天，回来的时候，小女孩特别<a href=\"http://www.duwenzhang.com/huati/kaixin/index1.html\">开心</a>，但也舍不得，到了第二天，<a href=\"http://www.duwenzhang.com/huati/muqin/index1.html\">母亲</a>坐着摩托车走了，小女孩追着摩托车，一边喊着“妈妈，别走”。</p><p>　　 是啊，作为城里的我们生活很幸福，也很<a href=\"http://www.duwenzhang.com/huati/zhizu/index1.html\">知足</a>，但作为农村的留守儿童来说，我们的幸福比起他们，永远算不上，因为，他们付出的，比起我们，真的太多太多了。</p><p>　　 离别，对于我们人类来说，不管是亲人，还是<a href=\"http://www.duwenzhang.com/huati/pengyou/index1.html\">朋友</a>，都会是一次巨大的打击，特别是亲人的离别，对于留守儿童来说，是一次永远都抹不去的<a href=\"http://www.duwenzhang.com/huati/huiyi/index1.html\">回忆</a>。</p><p>　　 愿那些孩子们，在离别中，学会成长，学会<a href=\"http://www.duwenzhang.com/huati/jianqiang/index1.html\">坚强</a>，也要学会勇敢，祝愿那些孩子们<a href=\"http://www.duwenzhang.com/huati/kuaile/index1.html\">快乐</a>成长！</p><p><img src=\"/static/uploadfiles/1585736674294_IDcard.jpg\" style=\"max-width:100%;\"></p>', '2020-04-01 10:11:53', '1', 'Mhou', '0', '', '1', '/static/uploadfiles/1585736674294_IDcard.jpg', '1000000', null);
INSERT INTO `notice` VALUES ('12', '资助留守儿童', 'Mhou', '<p><img src=\"/static/uploadfiles/1585736787774_IDcard.jpg\" style=\"max-width:100%;\"></p><p>你凝视窗外，双眸暗淡无光。</p><p>　　蓝天、白云，在你面前尽显妩媚;阳光、流水，纵情逗你开心。可你，却视而不见，迷惘的双眼，尽是寂寞。欢快的小鸟，美丽的杜鹃花，带给你的不是开心，而是忧郁;泪水是你心愿的表达。</p><p>　　你恨眼前美好的一切;</p><p>　　你渴望那温馨的关爱。</p><p>　　正当灿烂年华，无忧无虑的年代，可上帝却给了你一个可恶的名字“留守儿童”。你讨厌这个名字，你惧怕这个名字。你想爸爸，妈妈!可是，他们却只是一个遥远的声音与钱的体现。</p><p>　　孩子，面对你失落的心灵，我也迷惘。我不知道，留守儿童是不是中国独有的现象?但我知道，农村绝大多数外出打工的父母都抱着一个良好的愿望：为了孩子。我也知道，他们把年龄过小的你们独自留在家中或交给其他亲人看管，结果往往是得不偿失，你们因此受到的伤害是他们挣的钱所不能弥补。</p><p>　　我更知道，你们需要的是父母的爱，父母的关心，一家人的和睦团圆。</p><p>　　孩子，我希望老师的爱，能够弥补你心灵的这种爱的缺失。老师希望天上灿烂的阳光，天天挂在你幼稚的脸上，照亮你内心，伴你走过每春夏秋冬。</p><p>　　让“留守儿童”滚出去，让“阳光儿童”跳出来。</p><p>　　这是我的心愿。</p><p><img src=\"/static/uploadfiles/1585737069943_IDcard.jpg\" style=\"max-width:100%;\"></p>', '2020-04-01 10:15:02', '1', 'Mhou', '0', '', '1', '/static/uploadfiles/1585737069943_IDcard.jpg', '10000', null);
INSERT INTO `notice` VALUES ('13', '农村老人', 'Mhou', '<p>&nbsp;&nbsp;&nbsp;&nbsp;是谁的音符穿越了大地，在山头上流淌？是谁的号子划破了寂静的夜空，飘落在枝头？是谁的律动唤醒了农家懵懂少年的心，激起了<a href=\"https://www.baidu.com/s?wd=%E6%9C%B5%E6%9C%B5&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\">朵朵</a>爱情的浪花？ 是山歌，是乡村的山歌。 乡村的山歌是灵动的，有着旺盛的生命力，一如山头的小草。只要给它一点空间，它就会毫不讲理地蹦出来，四处流淌。山峦上、小溪边、大树下、草丛中、庄稼地里，到处都能闻到山歌的气息。 乡村的山歌是把沉默的泥土，深埋着村里人的情感，肥硕着乡村的日子，温暖着村里人的生活。村里人随便唱出一支山歌，都是那样的纯美，感情充沛，掷地有声，回味无穷。 乡村的山歌是首浪漫的诗，每一支山歌都是一个美丽的传说。放歌的村民个个都是伟大的诗人，他们在晨曦里低吟，在晚霞中浅唱，在阳光里抒情，在月光下舞蹈……壮阔激昂，吟咏春秋，收获爱情。 乡村的山歌是首流动的情歌，村里人走到那儿就唱到那儿。这首情歌不需要华丽的舞台，不需要闪烁的灯光，也不需要乐队的伴奏……但是，这首情歌有着难以估计的力量，它可以唱落星星，唱落月亮，可以拨动乌云，震撼太阳。 乡村的山歌是自由、快乐的，<a href=\"https://www.baidu.com/s?wd=%E6%83%B3%E5%94%B1%E5%B0%B1%E5%94%B1&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\">想唱就唱</a>，想哼就哼，想念就念。它没有限制，没有约束。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;劳动时可唱，休闲时可唱，走路时可唱，放牧时可唱……可走着唱，可蹲着唱，可躺着唱，一人可独唱，二人时可合唱，多人时可和唱，男女可以对唱，真可谓形式多样，无拘无束，完全不受任何唱法的干扰，只要自己快乐就行。山歌的内容也很丰富，或歌唱爱情的坚贞，或描写幸福的生活，或赞扬大好的河山，或针贬时弊，或诙谐调侃，或醒世育人……生活中的方方面面，无所不包，应有尽有。山歌的篇幅过于短小，演奏起来也较容易，一支短笛，一把二胡，一副唢呐，任何乐器都可以进行演奏，甚至于一张木叶，一个口哨都有能把它演绎得出神入化，让人久久不能忘怀。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;乡村的山歌是幸福的，村里人总是把它藏在心底，种在土里。希望它的每一个音符都生根发芽，开花结果，希望它的每一次律动都能博得阳光的眷顾，让山垣上下的每一株禾苗都健康地生长。 在村里人的眼中，乡村的山歌是珍贵的。每每农闲时刻，他们都要把山歌带到最向阳的山头去凉晒，风干，怕它发霉，怕它腐烂。&nbsp;</p><p><img src=\"/static/uploadfiles/1585736712941_IDcard.jpg\" style=\"max-width:100%;\"></p><p>&nbsp;&nbsp;&nbsp;&nbsp;在我的眼中，乡村的山歌已经超越了山歌的含义。它是村民们精神的寄托，是村民们幸福的源泉，更是我记忆中一抹永不褪色的丹青，一个古老而传奇的神话。\n\n</p><p><img src=\"/static/uploadfiles/1585736478961_IDcard.jpg\" style=\"max-width:100%;\"></p>', '2020-04-01 10:17:01', '1', 'Jie', '0', '', '1', '/static/uploadfiles/1585736478961_IDcard.jpg', '10000', null);
INSERT INTO `notice` VALUES ('14', '关爱农村老人', 'Mhou', '<p>&nbsp; &nbsp;<img src=\"/static/uploadfiles/1585737237669_IDcard.jpg\" style=\"max-width: 100%;\"></p><p>&nbsp;&nbsp;&nbsp;&nbsp;那是一个深秋的夜晚，天灰蒙蒙的，没有一丝暖意，让人感觉有一种莫名的失落感。天色越来越暗，头顶上布满了乌云，突然就起了一阵大风，街上的树枝到处摇晃着，人人纷纷往家跑。</p><p>　　好像是要下雨了。我加快了脚步，在大雨来临的前一秒我赶到了家门口。我习惯性的掏掏口袋，我脸色顿时变了颜色。糟糕!忘记带钥匙了!这可怎么办啊，妈妈还没有回来，现在又下着大雨……我心里着急的眼泪就要掉出来了。没办法，只好站在这里等妈妈了。</p><p>　　一到夜晚，天气就越来越冷，我整个人站在门口，双手抱臂瑟瑟发抖，心里期待着妈妈快点回来。在滂沱大雨中我看到了一个苍白的身影。原来是刘奶奶，她上半身被淋湿了。我关切的问她：“刘奶奶，你没事吧。快进去吧，不要着凉了。”刘奶奶慈祥的面容上展现出了笑颜：“你是不是在等你妈妈啊?外面这么冷，先去我家里待着吧，写着作业等你妈妈回来。看着下着的大雨，我心有点动摇了，却又不想麻烦刘奶奶。刘奶奶看出了我眼底的犹豫，二话不说的直接把我拽进她家，把牛奶，饼干，全部塞到我怀里：“吃完了就直接写作业了啊，把这里当你家一样。”我看着刘奶奶的面容，眼泪湿润了眼眶。</p><p>　　生活中，人与人之间的关爱就是如此简单。</p><p><strong>　　关爱老人的作文二：</strong></p><p>　　秋高气爽直，，天清气爽，又到重阳街头多了为老人服务的小站，报纸电台开始宣传如何敬老爱老，敬老院，颐养院趁势又多开了几家。</p><p>　　大多数为老人服务的小站都是真诚的，也有一部分是趁机销售一些所谓的治疗仪器。这边刚免费为老人做了简单的身体测量，那边就忙不叠拿出仪器向老人展示，施展浑身解数，巧舌如簧，誓必让老人买下不可。</p><p>　　一些单位在重阳那天，肯定会有行动，名为给老人送爱心，实际为单位赚名气，送些不靠谱的礼物，诸如视力保健仪之类的，老人用得上用不上可管不得了平时就经常有敬老院虐待老人的事情曝光，但是敬老院还是照样要开的，只是换个名字重整旗鼓而已。至于服务质量有没有改进，那就不得而知了。基于现在的社会环境，很多家庭都是一个小孩的，到我们年老的时候，由于各种原因，或孩子身处外地，，或工作关系，或自身原因，无暇照顾老人，很多人可能都有机会进老人院安度晚年，这样的状况怎么不让人为以后担忧呢?</p><p>　　真正关心老人，不要只在乎形式，不要在节日的时候才表达关怀，无需用金钱和物质去衡量关心的程度。身在外地的，一条短信，一通电话，只要是流露真心的问候，老人也会很高兴。经济不太好的，平时多帮老人做些家务，和老人聊聊天，也是最好的孝道。至于单位企业的节日献爱心，真正为老人们做点实事，少些沽名钓誉的虚浮吧。</p><p>　　关心老人，如何搞好夕阳工程，需要我们全社会的关注和努力，善待老人吧，就是善待我们自己。</p><p><br></p>', '2020-04-01 10:18:54', '1', 'Ruan', '0', '', '1', '/static/uploadfiles/1585737237669_IDcard.jpg', '88888', null);
INSERT INTO `notice` VALUES ('15', '贫困几乎是与生俱来的', 'Mhou', '<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;贫富几乎是与生俱来、无从选择的。要是在孩子刚刚开始懂事时，成人社会就有意无意地加深他们的贫富意识，那么对穷孩子来说，强烈的贫富意识往往会使得原本就十分自卑的心理雪上加霜；而对富孩子来说，由此而生的盲目的优越感往往会导致他们成为自以为“高人一等”的<a href=\"https://www.baidu.com/s?wd=%E5%B0%8F%E9%9C%B8%E7%8E%8B&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\">小霸王</a>。<br>　　有这样一个故事。纽约的冬天十分寒冷，几尺厚的积雪使部分单位和商家不得不暂时歇业。可是，公立小学却依旧照常开课。刚全家移民的陈太太对校方的这种做法很不理解，打电话给学校提出停课的建议。校方答复：“接送孩子到学校上学，他们不仅能享受一整天的温暖，还能在学校里享受到免费的<a href=\"https://www.baidu.com/s?wd=%E8%90%A5%E5%85%BB%E5%8D%88%E9%A4%90&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\">营养午餐</a>！”感动之余，陈太太灵机一动，想出一个两全其美的法子，她又打了一个电话：“为什么不在有暴风雪时，让家庭条件好的孩子们待在温暖的家里，只接送那些贫穷人家的小孩儿去学校呢？”这一次，校方的回答令陈太太终身难忘——“<a href=\"https://www.baidu.com/s?wd=%E6%96%BD%E6%81%A9&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\">施恩</a>的最高境界应该是保持人的尊严。我们不能在帮助那些贫穷孩子的同时，却践踏了他们的自尊。”<br>　　<a href=\"https://www.baidu.com/s?wd=%E8%B4%AB%E5%AF%8C%E5%B7%AE%E8%B7%9D&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\">贫富差距</a>是社会客观存在的现象。但不少人之所以贫困，并不是因为能力不足或努力不够，在某种程度上是由于机会不均等造成的。因此，在人与人之间，尤其是在孩子与孩子之间，应该淡化贫富差别。<br>　　5月中旬的一天，在长春市某小学门前，等候已久的王大爷接到了小学二年级的孙子小曦。放学时分，数以百计的轿车、微型面包车拥堵在校门口，祖孙俩在车群中穿行，到对面的62路车站准备乘车回家。<br>　　“爷爷，为什么别的同学家有车，可咱家没有？”小曦问。<br>　　“因为家里没钱买！”王大爷无奈地回答。<br>　　“没钱！你和爸爸工作时咋不努力多挣点儿钱呢？”小曦又问。<br>　　这回，爷爷半天无语。</p><p><img src=\"/static/uploadfiles/1585736603541_IDcard.jpg\" style=\"max-width:100%;\"><br>　　“有钱就可以买新衣服，有钱就可以下饭店，有钱就可以车接车送……”<a href=\"https://www.baidu.com/s?wd=%E4%B8%9C%E5%8C%97%E5%B8%88%E5%A4%A7%E9%99%84%E5%B0%8F&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\">东北师大附小</a>的一位女老师认为，“大人对<a href=\"https://www.baidu.com/s?wd=%E8%B4%AB%E5%AF%8C%E5%B7%AE%E8%B7%9D&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\">贫富差距</a>习以为常，就以为孩子也是一样的想法，这是不正确的。”<br>　　家境的贫富在很大程度上会影响学生的成长。家境差的可能考上学却读不起，家境好的同学差几分，交上钱就是重点中学的自费生。对家境不好的孩子来说，几万元钱超过了他们家的全部积蓄。即便减免费用进了学校，还是会因为同学之间家境的<a href=\"https://www.baidu.com/s?wd=%E8%B4%AB%E5%AF%8C%E5%B7%AE%E8%B7%9D&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\">贫富差距</a>，使那些贫寒家庭的孩子产生心理压力。看到身边的同学总是吃麦当劳、肯德基，自己却只能吃青汤白菜；别人逛商场、买名牌，自己却只能穿几套从家里带来的衣服，再加上周围的有色眼光，久而久之，难免自卑。家长和老师应给予足够的开导和鼓励，否则严重时会导致孩子对现实社会产生不满情绪，对他人产生敌对心理。<br>　　让孩子有正确的认识，作为家长首先得有一个正确的认识。听说别的同学家里有钱，就告诉孩子说人家是贪占的，是靠不光彩渠道得来的，这会影响孩子的认识和判断。要对孩子说，爸爸妈妈工作很努力，只不过班上某某同学的家长更努力、更优秀。只要我们努力了，付出了，贫穷一定是可以改变的。</p><p><img src=\"/static/uploadfiles/1585736598254_IDcard.jpg\" style=\"max-width:100%;\"><br>　　富裕是我们可以追求的，作为学生，家境贫穷并不可耻。然而，以强凌弱却是可耻的，同样的道理，以富欺贫也是不道德的。学生正确面对家境的贫富很重要，面对这种贫富现象应该有一颗平常心，如果把贫穷转化为奋斗的动力，更是一个明智的选择。作为大人要告诉孩子，养育他们并不是一件容易的事，孩子们要学会用长远的眼光去审视贫富差距及相关的事物，用平和的心态去面对，同时积极地完善自我，努力学习，争取在不久的将来，在实现自我价值的同时，为社会和自己创造更多的财富！\n\n</p><p><br></p>', '2020-04-01 10:21:02', '1', 'Shen', '0', '', '1', '/static/uploadfiles/1585736598254_IDcard.jpg', '256398', null);
INSERT INTO `notice` VALUES ('16', '扶持贫困家庭', 'Mhou', '<p>大家都知道农村的低保政策，是为了帮助在农村一些家庭困难的人保证一个最低的生活标准，让他们能够在低保政策的扶持下，再通过自己的劳动能力获得收入，早点脱离贫困。当然在农村也不是所有家庭困难的人都可以享受得到低保政策的扶持与帮助，他们并不是全都可以享受低保政策带来的福利。能不能享受低保政策的扶持？还是要看他们导致贫困的原因是什么，如果导致家庭贫困的原因并不符合享受低保的标准，那申请低保也是不会被通过的。</p><div><img src=\"https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2650904710,3521742128&amp;fm=173&amp;app=25&amp;f=JPEG?w=640&amp;h=480&amp;s=9DB6FEB346C306E60884FCBC03005063\"></div><p>第一个原因，因为违法犯罪行为或是不良嗜好导致贫困的家庭</p><p>因为在农村有很多农民朋友们，不太明白法律的意义何在，所以说他们很有可能就会因为一些违法犯罪行为导致家里的财产大量流失，比如说非法集资，或者说是因为吸毒赌博等一些不良嗜好导致家庭困难，当然这都是属于违法犯罪行为。而因为这些违法犯罪行为，或者是一些不良嗜好，导致贫困的家庭，申请低保政策的扶持是不会被通过的，因为他们导致家庭贫困的原因不符合申请低保的标准。</p><div><img src=\"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2713306688,159226648&amp;fm=173&amp;app=25&amp;f=JPEG?w=640&amp;h=480&amp;s=CF7413C26F67B65D02D5581F0300E0C1\"></div><p>第二个原因，因为结婚彩礼导致贫困的家庭</p><p>要知道现在农村的天价彩礼问题还是一个非常难解决的事情，现在农村嫁女儿都会要非常高的彩礼，这些彩礼让一个普通的农民家庭会有一些缓不过来，毕竟一个家庭攒了一辈子的积蓄，可能就花到了儿子娶媳妇的这件事上。所以说现在在农村，也有很多家庭是因为给儿子娶媳妇导致家庭贫困的。但是在农村，因为结婚的彩礼问题导致贫困的家庭，申请低保政策的扶持将不会被通过的，因为他们导致贫困的原因，并不符合享受低保政策扶持的标准。</p><div><img src=\"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=518090990,982927603&amp;fm=173&amp;app=25&amp;f=JPEG?w=640&amp;h=480&amp;s=3D4E377E47526C644EFD40E80200E033\"></div><p>第三个原因，因为攀比等多次重大消费导致贫困的家庭</p><p>每个人都非常在乎自己的面子，所以说有些时候人们总会因为保住自己的面子，出现一些并不符合自身财产情况的消费。就好像是出去吃饭给人家随礼，别人家随多少礼，自己就得随多少，就算自己拿不出这些钱来，借钱，也要保住自己的面子。所以说在农村也有很多人是因为攀比等多次重大消费导致家庭困难的。但是在农村，因为攀比或者是其他重大消费，除医疗以外的重大消费，导致贫困的家庭想要申请低保政策的扶持是不会被通过的。</p><p><img src=\"/static/uploadfiles/1585737320906_IDcard.jpg\" style=\"max-width:100%;\"></p>', '2020-04-01 10:22:36', '1', 'Shan', '12365', '', '1', '/static/uploadfiles/1585737320906_IDcard.jpg', '987654', null);
INSERT INTO `notice` VALUES ('18', '帮扶困难家庭计划', 'Mhou', '<p>大灾过后的漳县三条沟村,青山含黛,绿水如蓝,一排排帐篷里飘着缕缕炊烟,帐篷学校里传来朗朗书声,一切似乎又恢复了从前的安详宁静。只有不远处坍塌的房屋和乡亲们脸上偶尔流露出的悲戚提醒着人们这里曾经发生的一切。</p><p>在岷县漳县6.6级地震中,三条沟村一位叫康折桃的母亲为救女儿杨小莲而献出了自己44岁的生命,定西日报记者就此采写了通讯《致敬,为了一位母亲》,文章于7月30日见报后,康折桃伟大的母爱震撼了无数人的心灵,同时也深深牵动了一位省人大代表、农民张永忠的心。他一遍遍捧读着报纸,感动得一夜没有睡好觉,尤其是杨小莲站在老屋前思念母亲的照片,令张永忠一次又一次泪湿衣衫。他在深思熟虑之后,决定用自己的方式完成这位母亲未完成的心愿。</p><p>第二天,张永忠买了方便面等物品,开车来到失去妻子的杨永平家:父女俩在帐篷里住着,一间老房子震裂,房顶开了天窗,石砾满院,一辆电动摩托车面目全非,家中一贫如洗。看着这个贫困的家庭,张永忠眼眶里再一次流出了泪水。他对杨小莲说:“孩子,你用心读书,我资助你上高中、上大学,完成你母亲的夙愿。”并拿出2000元交给了杨小莲,父女俩感动得不知说什么好,连声说:“你是个好人!”</p><p>张永忠也是个苦出身,他的家乡在马泉乡的一个山村里,几十年来,他从开茶叶店起家,靠着诚实守信,一步步把生意从山村做到了县城,过上了富裕的日子。地震发生当天下午,张永忠就给三条沟重灾区群众送去了100箱方便面和矿泉水,并捐款3000元。新寺镇桥头村双联户陈汇,孩子考上大学后,他资助了500元,地震中陈汇家房屋裂缝,一间倒塌,张永忠又上门去看望,并送去了慰问金2000元。</p><p>在灾难面前,张永忠用自己的爱心,为灾区群众送去了温暖,展现了一位省人大代表的高尚情怀。</p><p><img src=\"/static/uploadfiles/1585738163454_IDcard.jpg\" style=\"max-width:100%;\"><img src=\"/static/uploadfiles/1585738306623_IDcard.jpg\" style=\"max-width: 100%;\"></p>', '2020-04-01 10:39:09', '1', 'Ruan', '0', '', '2', '/static/uploadfiles/1585738306623_IDcard.jpg', '136524', null);
INSERT INTO `notice` VALUES ('19', '关爱留守儿童项目', 'Mhou', '<p><img src=\"/static/uploadfiles/1585738494220_IDcard.jpg\" style=\"max-width:100%;\"><img src=\"/static/uploadfiles/1585738354603_IDcard.jpg\" style=\"max-width: 100%;\"></p><div label-module=\"para\">留守儿童是指外出务工连续三个月以上的农民托留在户籍所在地家乡，由父、母单方或其他亲属监护接受义务教育的适龄儿童少年。</div><div label-module=\"para\">2013年，全国妇联根据中国2010年第六次人口普查数据推算，中国共有6102.55万农村留守儿童。而2016年多部门联合开展的农村留守儿童摸底排查工作统计认为，全国不满16周岁、父母均外出务工的农村留守儿童数量为902万人。<sup>&nbsp;[1]</sup><a name=\"ref_[1]_20330775\">&nbsp;</a>&nbsp;留守儿童的数量从6102万到902万有以下原因：其一是留守儿童的年龄截止期限。过去的报告是以不满18周岁为口径的统计，而这次的统计口径却是不满16周岁。其二是统计范围上的差异，旧的报告是以父母一方外出即算留守儿童，而新的统计方式却是只有父母双方外出务工，或一方外出务工，另一方无监护能力的，才算是留守儿童。两相比较，数字大幅度缩水就不足为奇了。双亲留守儿童：父母双方都在外地打工，由其他亲属监护。单亲留守儿童：父母一方外出打工，另一方离异或死亡或无监护能力，由其他亲属监护的儿童。</div><div label-module=\"para\">2012年9月，教育部公布义务教育随迁子女超1260万，义务教育阶段留守儿童2200万。近年来发生的一系列不好的“留守儿童”的事件，让人们对留守儿童问题心理的剖析深入，使得一部分留守儿童的成长压力增大。事实上，并非所有留守儿童都像报道的那样只有不好的一面。坚强乐观，自信懂事，天真活泼，爱玩爱闹也是大部分留守儿童真实生活的写照<sup>&nbsp;[2]</sup><a name=\"ref_[2]_20330775\">&nbsp;</a>&nbsp;。</div>', '2020-04-01 10:40:50', '1', 'Yan', '0', '', '2', '/static/uploadfiles/1585738354603_IDcard.jpg', '654321', null);
INSERT INTO `notice` VALUES ('20', '农村老人扶持活动', 'Mhou', '<p><img src=\"/static/uploadfiles/1585738513953_IDcard.jpg\" style=\"max-width:100%;\"><img src=\"/static/uploadfiles/1585738115535_IDcard.jpg\" style=\"max-width: 100%;\"></p><p><img src=\"/static/uploadfiles/1585738104940_IDcard.jpg\" style=\"max-width:100%;\"></p><p>农村和城里存在怎样的差距？城市老人在跳广场舞，农村老人在打工！大家一直都在说，全国各地都有不同的经营理念和不同的风景区，都会给人不一样的感情，这就是一个真实情况，因为每个城市不可能就像是复制的一样，一模一样，具有每个城市的特色，而在每个城市当中不同的地区也有不同的感受和风气。</p><div><img src=\"https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3033666607,2667678777&amp;fm=173&amp;app=49&amp;f=JPEG?w=640&amp;h=534&amp;s=494F499216415EF90B94F3F40300703D\"></div><p>其实中国地大广阔，有很多个城市，而在每个城市当中必不可少的就是农村地区和城市地区，其实说到这两个地方都非常熟悉城市，无非就是经济非常发达，而农村经济落后，虽然已经在国家的帮助下初见发展的势头也前景非常的好，但是跟发达城市相比还是非常的落后，而民生则是国家关注的重点。</p><div><img src=\"https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=106779004,3712157099&amp;fm=173&amp;app=49&amp;f=JPEG?w=609&amp;h=517&amp;s=4F104D8140030AF94695A5960300D082\"></div><p>有人想问，农村和城市存在怎样的差距？那今天小编就带大家一起去看一下，在城市中老人都在跳广场舞，非常的悠闲，因为城市的老人经济非常发达，他们到达一定的年龄，都在工厂上班，到了退休的年纪自然会给退休工资，足够他们生活，而且他们的儿女早已成家，有的老人帮助儿女减轻负担，回去就会帮孩子带孩子。</p><div><img src=\"https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=173072791,1670031879&amp;fm=173&amp;app=49&amp;f=JPEG?w=640&amp;h=504&amp;s=57DE189B42034EE415B9C3EE0300B03C\"></div><p>当然也有很多家庭的孩子经济非常的好，所以孩子们明白父母为自己付出了多少，所以在父母老了的时候，他们不舍得让父母给自己带孩子，所以每个家庭当中都会有保姆，而父母只想这颐养天年，每天都在广场上跳广场舞，非常的悠闲自在轻松，正因为他们衣食无忧，不用操心任何的事，而农村人的生活状态不同。</p><div><img src=\"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=4006892669,3488878025&amp;fm=173&amp;app=49&amp;f=JPEG?w=636&amp;h=538&amp;s=4F130DC70813A6D44AC58C020300F051\"></div><p>农村人的经济落后，所以每个家庭的温饱问题都非常的担忧，如今农村人口老龄化严重，这个原因导致就是因为每个家庭的经济状况非常的差，种地粮食卖不上价钱，所以有很多青壮劳力都会选择去大城市中打工。大城市中经济发达的确有很多的机会，但是背井离乡这种滋味搁在身上都非常的不好受。</p><div><img src=\"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2431924503,4061011182&amp;fm=173&amp;app=49&amp;f=JPEG?w=627&amp;h=511&amp;s=4D720DC5CC73B7DC044875000300F090\"></div><p>而农村的老人压力也非常的大，因为家庭条件的原因，所以很大的年纪也要在外打工。目的就是因为想为自己挣一份养老钱，因为家庭负担重，儿女们的压力也非常大，所以农村很多老人在年龄很大的时候还在外打工，以求一份养老金帮子女减轻负担，其实想别人觉得问题，最根本的根源就在于经济。</p><div><img src=\"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=343759127,1839626591&amp;fm=173&amp;app=49&amp;f=JPEG?w=620&amp;h=513&amp;s=D2839A459F33C1CE0C8C387A03001013\"></div><p>如果农村老人能够像城市老人一样有一份退休金或者有一个稳定的经济生活呢，他们也可以安安心心的在家里跳广场舞，或者和外边的人一起聊天，不必在这么大年纪还在外打工。</p>', '2020-04-01 10:42:58', '1', 'Xing', '0', '', '2', '/static/uploadfiles/1585738104940_IDcard.jpg', '326548', null);
INSERT INTO `notice` VALUES ('21', '关爱自闭儿童', 'Mhou', '<p><img src=\"/static/uploadfiles/1585737992507_IDcard.jpg\" style=\"max-width:100%;\"></p><p>I’m a little used to calling outside your name</p><p>我有些习惯在外面大喊你的名字</p><p>I won\'t see you tonight so I can keep from going insane</p><p>今晚若见你 我可能失去控制</p><p>But I don\'t know enough, I get some kind of lazy day</p><p>但我不解，时间变的有些缓慢</p><p>I\'ve been fabulous through to fight my town a name</p><p>我曾与众不同 名震一方</p><p>I\'ll be stooped tomorrow if I don\'t leave as them both the same</p><p>如果我离开 随波逐流 只会碌碌无为</p><p>But I don\'t know enough, I get some kind of lazy day</p><p>我有些不解，时间变的有些缓慢</p><p>Cause It\'s hard for me to lose in my life I\'ve found</p><p>因为失去你是一种煎熬</p><p>Only time will tell and I will figure out</p><p>我发觉在我的生活中只有时间可以证明一切</p><p>That we can baby, we can do the one night stand</p><p>亲爱的 我会找到答案 至少我们可以相拥整夜</p><p>And it\'s hard for me to lose in my life I\'ve found</p><p>因为失去你是一种煎熬</p><p>Outside your skin right near the fire</p><p>我发现你在街头流离 憔悴不堪</p><p>That we can baby we can change and feel alright</p><p>宝贝 我们可以扭转一切共渡难关</p><p>I\'m a little used to wandering outside the rain</p><p>我已习惯在雨中漫步</p><p>You could leave me tomorrow if it suits you just the same</p><p>如果你有新的彼岸 大可在天明离我而去</p><p>But I don\'t know enough, I need sun when it leaves the day</p><p>但我不解 其实我需要那个离去的人</p><p>Cause It\'s hard for me to lose in my life I\'ve found</p><p>因为失去你是一种煎熬</p><p>Only time will tell and I will figure out</p><p>我发觉在我的生活中只有时间可以证明一切</p><p>That we can baby, we can do the one night stand</p><p>亲爱的 我会找到答案 但我们至少可以共渡今夜</p><p>And it\'s hard for me to lose in my life I\'ve found</p><p>因为失去你是一种煎熬</p><p>Outside your skin right near the fire</p><p>我发现你在街头流离 憔悴不堪</p><p>That we can baby we can change and feel alright</p><p>宝贝 我们可以扭转一切共渡难关</p><p>&nbsp;</p><p>Cause It\'s hard for me to lose in my life I\'ve found</p><p>因为失去你是一种煎熬</p><p>Only time will tell and I will figure out</p><p>我发觉在我的生活中只有时间可以证明一切</p><p>That we can baby, we can do the one night stand</p><p>亲爱的 我会找到答案 但我们至少可以共渡今夜</p><p>And it\'s hard for me to lose in my life I\'ve found</p><p>因为失去你是一种煎熬</p><p>Outside your skin right near the fire</p><p>我发现你在街头流离 憔悴不堪</p><p>That we can baby we can change and feel alright</p><p>宝贝 我们可以扭转一切共渡难关</p><p>Cause It\'s hard for me to lose in my life I\'ve found</p><p>因为失去你是一种煎熬</p><p>Only time will tell and I will figure out</p><p>我发觉在我的生活中只有时间可以证明一切</p><p>That we can baby, we can do the one night stand</p><p>亲爱的 我会找到答案 但我们至少可以共渡今夜</p><p>And it\'s hard for me to lose in my life I\'ve found</p><p>因为失去你是一种煎熬</p><p>Outside your skin right near the fire</p><p>我发现你在街头流离 憔悴不堪</p><p>That we can baby we can change and feel alright</p><p><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"><divsegoe ui=\"\" emoji\',=\"\" \'segoe=\"\" symbol\',=\"\" sans-serif,=\"\" simsun;=\"\" font-size:=\"\" 14.399999618530273px;=\"\" font-style:=\"\" normal;=\"\" font-variant:=\"\" font-weight:=\"\" letter-spacing:=\"\" line-height:=\"\" 12.767999649047852px;=\"\" orphans:=\"\" auto;=\"\" text-align:=\"\" start;=\"\" text-indent:=\"\" 0px;=\"\" text-transform:=\"\" none;=\"\" white-space:=\"\" widows:=\"\" word-spacing:=\"\" -webkit-text-stroke-width:=\"\" background-color:=\"\" rgb(250,=\"\" 250,=\"\" 250);\"=\"\"></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></divsegoe></p><p>宝贝 我们可以扭转一切共渡难关</p><p><br></p>', '2020-04-01 10:45:07', '1', 'Mhou', '0', '', '2', '/static/uploadfiles/1585737992507_IDcard.jpg', '98765', null);
INSERT INTO `notice` VALUES ('22', '她们的身后不再是一个人', 'Mhou', '<h3>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <span style=\"font-weight: bold;\">&nbsp; 他们其实过得不是很好</span></h3><h1><img src=\"/static/uploadfiles/1588944682747_IDcard.jpg\" style=\"max-width:100%;\"></h1><div><div><p>我们总说鱼水交融，却不知道没有水鱼会死亡，水没有鱼却更显清澈。</p><p>可能不是我们不知道，而是我们下意识的不去想，不去想这些让我们难过的事情。</p><p>趋利避害是人的本能。</p><p>但是，实际上我们忘不了的人，早已经遗忘了我们，对我们只有一些模糊的片段。</p><p>没有我们，其实他们过的更好。</p><p>这是我们不想去考虑的，人总是沉溺感动自己的深渊里，理所当然的想着我想他，他也想我。我离开他，我很难过，他也不好过。</p><p>实际上，后来的我们，都各自有各自的幸福，谁忘不了，谁就少了一分幸福，多了一分记忆。</p><p>模糊自己那些不该有的记忆吧，让自己淡然的面对失去，淡然的迎接拥有。</p><p>得之淡然，失之坦然。出自：江南之喃</p></div></div>', '2020-05-08 13:17:54', '1', 'Mhou', '10000', '', '1', '/static/uploadfiles/1588944682747_IDcard.jpg', '20000', '我们可以尽自己所能，帮帮她们，我们应该可以做得更好的。');
INSERT INTO `notice` VALUES ('23', '请帮忙找找他的孩子吧', 'Mhou', '<h2><span style=\"font-weight: bold;\">孩子的照片</span></h2><div><img src=\"/static/uploadfiles/1588945016757_IDcard.jpg\" style=\"max-width:100%;\"><img src=\"/static/uploadfiles/1588944457767_IDcard.jpg\" style=\"max-width: 100%;\"></div><p>&nbsp;&nbsp;&nbsp;&nbsp;在整部影片的结尾，再次踏上寻子之路的雷泽宽，在路上遇到了一队僧侣。他停下来，与僧侣们一起休息，并把自己的吃食赠与他们。也许是因曾帅的结局有所感触，也许是十五年来的疲劳积累成了一声叹息，雷泽宽想要知道为什么被拐的是自己的孩子，自己已经找了十五年，究竟还能不能找到他。而大师合掌，只给了他一个缘聚缘散，<a href=\"https://www.baidu.com/s?wd=%E7%BC%98%E8%B5%B7%E7%BC%98%E7%81%AD&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\">缘起缘灭</a>，看似虚无的回答。<br>　　有时候，一个问题的答案，并不只有一个。就好像人与人之间，总是存在着无形的连结，有着某种必然存在的相遇的机会和可能。世事无常，雷泽宽骑着车<a href=\"https://www.baidu.com/s?wd=%E8%B5%B0%E5%90%91%E8%BF%9C%E6%96%B9&amp;tn=SE_PcZhidaonwhc_ngpagmjz&amp;rsv_dl=gh_pc_zhidao\" target=\"_blank\">走向远方</a>，因为“只有在路上我才觉得自己是一个父亲”，他不对结果抱有期望，只是希望一个精神支柱让他继续下去。没有目的的坚持，就是一种信念。而这样禅意的结尾，无论对于影片中的人物，还是观看影片的观众来说，都是一种心理慰藉吧。\n\n</p>', '2020-05-08 13:24:29', '1', 'Jie', '0', '', '3', '/static/uploadfiles/1588944457767_IDcard.jpg', '0', '有线索，第一时间联系我们');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `Rid` int(11) NOT NULL AUTO_INCREMENT,
  `Rname` varchar(20) DEFAULT NULL,
  `Permissionlevel` int(11) DEFAULT NULL,
  PRIMARY KEY (`Rid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户的角色信息表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '0');
INSERT INTO `role` VALUES ('2', '管理员', '1');
INSERT INTO `role` VALUES ('3', '审核员', '2');
INSERT INTO `role` VALUES ('4', '编写人员', '3');
INSERT INTO `role` VALUES ('5', '普通用户', '4');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `Sid` int(11) NOT NULL AUTO_INCREMENT,
  `Suid` int(11) DEFAULT NULL,
  `Stime` date DEFAULT NULL,
  `Score` varchar(10) DEFAULT NULL,
  `Saward` varchar(20) DEFAULT NULL,
  `Scause` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Sid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='用户年度公益评分表';

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('11', '23', '2020-03-16', '100', null, '10000个口罩和捐赠100000');
INSERT INTO `score` VALUES ('12', null, '2020-03-16', '100', null, '5000套防护服和捐赠了10000元');
INSERT INTO `score` VALUES ('13', '24', '2020-03-29', '100', null, '捐赠1000元');
INSERT INTO `score` VALUES ('14', '33', '2020-03-29', '100', null, '捐赠10000元');
INSERT INTO `score` VALUES ('15', '25', '2020-03-29', '97', null, '捐赠500个书包');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Uid` int(11) NOT NULL AUTO_INCREMENT,
  `Uname` varchar(20) DEFAULT NULL,
  `Upassword` varchar(20) DEFAULT NULL,
  `Username` varchar(20) DEFAULT NULL,
  `Usex` varchar(20) DEFAULT NULL,
  `Uemail` varchar(50) DEFAULT NULL,
  `Uiphone` varchar(20) DEFAULT NULL,
  `Udatetime` date DEFAULT NULL,
  `Uaddress` varchar(100) DEFAULT NULL,
  `Uimage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Uid`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='用户个人信息表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('23', '陈明浩', '123321', 'Mhou', '男', '1063493030@qq.com', '13433623007', '2020-03-08', '广东茂名市高州市大井镇', '/static/images/07d50f72-39aa-4ed3-a520-eaf09a5361bf.jpg');
INSERT INTO `user` VALUES ('24', '陈明杰', '123456', 'Jie', '男', '1569910190@qq.ocm', '13436257892', '2020-03-08', '广东茂名市高州市大井镇', '/static/images/noimage.jpg');
INSERT INTO `user` VALUES ('25', '深', '123456', 'Shen', '男', '1229047925@qq.com', '13652478950', '2020-03-16', '广东茂名市高州市大井镇', '/static/images/6ea51e39-57a8-49c0-8c62-824c5c11bc59.jpg');
INSERT INTO `user` VALUES ('26', '珊', '123456', 'Shan', '女', '1587463290@qq.com', '15263478925', '2020-03-16', '广东茂名市高州市', '/static/images/noimage.jpg');
INSERT INTO `user` VALUES ('27', '恒', '123456', 'Heng', '男', '15248963710@qq.com', '15247896320', '2020-03-16', '广东茂名市高州市', '/static/images/noimage.jpg');
INSERT INTO `user` VALUES ('28', '炎', '123456', 'Yan', '男', '1856347899@qq.com', '15247896340', '2020-03-16', '广东茂名市高州市', '/static/images/noimage.jpg');
INSERT INTO `user` VALUES ('29', '幸', '123456', 'Xing', '男', '147896325@qq.com', '17896425805', '2020-03-16', '广东茂名市高州市', '/static/images/noimage.jpg');
INSERT INTO `user` VALUES ('33', '慧', '123456', 'Ruan', '女', '1299484739@qq.com', '13654289720', '2020-03-26', '广东茂名市高州市大井镇', '/static/images/noimage.jpg');
INSERT INTO `user` VALUES ('35', '锋', '123456', 'Feng', '男', '136254892@qq.com', '13652493287', '2020-04-03', '广东茂名市高州市', '/static/images/noimage.jpg');
INSERT INTO `user` VALUES ('36', '珍', '123456', 'Zhen', '女', '362548910@qq.com', '14287632589', '2020-04-03', '广东茂名市高州市', '/static/images/noimage.jpg');
INSERT INTO `user` VALUES ('37', '明哥', '123456', '小明', '男', '1632548@qq.com', '15236479991', '2020-04-20', '北京市辖区东城区', '/static/images/noimage.jpg');
INSERT INTO `user` VALUES ('38', 'XXX', '123456', 'XXX', '男', '102365478@qq.com', '15236478910', '2020-05-03', '北京市辖区东城区', '/static/images/noimage.jpg');

-- ----------------------------
-- Table structure for userrole
-- ----------------------------
DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `URid` int(11) NOT NULL AUTO_INCREMENT,
  `Roleid` int(11) NOT NULL,
  `Userid` int(11) NOT NULL,
  PRIMARY KEY (`URid`),
  KEY `FK_Role` (`Roleid`),
  KEY `FK_User` (`Userid`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='用户和角色之间的关系表';

-- ----------------------------
-- Records of userrole
-- ----------------------------
INSERT INTO `userrole` VALUES ('18', '1', '23');
INSERT INTO `userrole` VALUES ('19', '1', '24');
INSERT INTO `userrole` VALUES ('20', '3', '25');
INSERT INTO `userrole` VALUES ('24', '4', '26');
INSERT INTO `userrole` VALUES ('25', '5', '27');
INSERT INTO `userrole` VALUES ('26', '5', '28');
INSERT INTO `userrole` VALUES ('27', '5', '29');
INSERT INTO `userrole` VALUES ('31', '1', '33');
INSERT INTO `userrole` VALUES ('33', '1', '35');
INSERT INTO `userrole` VALUES ('34', '1', '36');
INSERT INTO `userrole` VALUES ('35', '5', '37');
INSERT INTO `userrole` VALUES ('36', '5', '38');
