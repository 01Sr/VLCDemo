package com.example.pingtaitest.utils;

import org.apache.http.client.HttpClient;

import android.util.Log;


public class GetURLControl {

	public static String httpGet(int deviceID)
	{
		String url_get="";
		switch (deviceID)
		{	/* 	case 4801:    //南门上
    		url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003211&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=1881FD885A9E713D39FCA83C0910D615";
			break;
    	case 4802:    //南门下
    		url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003211&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=E336C8DDE2897247BAFF88CAB40451A3";
			break;
    	case 4803:    //南门左
    		url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003211&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=33D60B3D282216AFA9C61FE8FF3530F4";
			break;
    	case 4804:    //南门右
    		url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003211&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=B9C32A59A151B3E8DCC93CFCF7522088";
			break;*/

		case 701:   //东9-2 上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003164&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=6DFB04956291373E10E72D87D93D176C";
			break;
		case 702:   //东9-2 下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003164&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=EAF7C387922F4515FBA6CAE1D0742033";
			break;
		case 703:   //东9-2 左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003164&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=49A7A51A8ED1B4CBE0A14CF6DAB5B56B";
			break;
		case 704:   //东9-2 右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003164&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=F74AEDB6065D855E5A75EFDCC82C23EC";
			break;

		case 801:   //西12 上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003165&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=23078D61F7ABE796D3BD9F3FD458A77F";
			break;
		case 802:   //西12 下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003165&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=AF2AA876CA55C5936F97571D80353028";
			break;
		case 803:   //西12 左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003165&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=3D06CE13C0821C586CE814B1440898EC";
			break;
		case 804:   //西12 右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003165&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=8A85328C1E57B7A88036F10D00D71887";
			break;

		case 901:   //西12 上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003166&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=098790DBC0839806B1B6AEC9775F70CA";
			break;
		case 902:   //西12下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003166&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=4DA4EE268A29893B2EAC1D31BABB867B";
			break;
		case 903:   //西12左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003166&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=31406C9E0EFB628D429CE4AD54397D11";
			break;
		case 904:   //西12右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003166&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=6764AB8D56CCA34C79CE3BA13189CD3D";
			break;

		case 1001:  //西15上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003167&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=97575607DE2D99ED15F580B809AC4E70";
			break;
		case 1002:  //西15下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003167&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=8D8A00C04412AF36A5406457D77F1CE2";
			break;
		case 1003:  //西15左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003167&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=F1C2D6B1A60F76C65C305627D0E62EE6";
			break;
		case 1004:  //西15右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003167&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=3E4D31A0058DB93BCBC6F51A13E0651B";
			break;

		case 1101:  //东12上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003168&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=13DC68C6F068C0B8044AC7B4D47F457C";
			break;
		case 1102:  //东12下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003168&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=FE7A5311132596067CB9B144728F2FA0";
			break;
		case 1103:  //东12左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003168&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=6B0B4F08C60A2EFE51EC872AB031B573";
			break;
		case 1104:  //东12右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003168&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=73FFF3C7686F386EC7E1812220FE2DFF";
			break;


		case 1201:   //东8上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003169&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=279CDE40F99104B9CCE9E9FAB387C516";
			break;
		case 1202:   //东8下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003169&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=994ADB7B455FE014977C9D169E57FA6B";
			break;
		case 1203:   //东8左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003169&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=FF05AA3184C002250C271A7488405378";
			break;
		case 1204:   //东8右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003169&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=46546FFCAC665229E6C17102CD81C775";
			break;


		case 1301:   //东7上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003170&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=F5AFDBB5465355C6005EB5BAFB7EBB28";
			break;
		case 1302:   //东7下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003170&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=CD22F0D10768ACA23C9F951AF0906286";
			break;
		case 1303:   //东7左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003170&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=453E9F5E6C8E62D5D3ED61A31773FE4E";
			break;
		case 1304:   //东7右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003170&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=D478B375B365841C0F37BBC89E4F45DA";
			break;

		case 1401:   //西14上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003171&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=E51EAA5348759F4D6EB75104C6756073";
			break;
		case 1402:   //西14下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003171&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=B93B6F8CBA11B9CFF864AC9709176C2E";
			break;
		case 1403:   //西14左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003171&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=7BCEF4B34310CD49649FE033F6B36B00";
			break;
		case 1404:   //西14右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003171&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=FF675B7FFF03A7E90F90AF0ACC88D63E";
			break;


		case 1501:   //西10上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003172&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=E2C3E640CB9259A8E8260A052480D1FB";
			break;
		case 1502:   //西10下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003172&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=DF53A98D474A92F9AA3978694FE2365D";
			break;
		case 1503:   //西10左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003172&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=9E30F24FEE189FCB2049BD6B8E5248E8";
			break;
		case 1504:   //西10右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003172&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=5751C276D6F7A2551FA432C7DFD4ACB4";
			break;

		case 1601:   //东15上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003173&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=591F9B9F232317A3D5D0919CEE6AE7FC";
			break;
		case 1602:   //东15下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003173&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=FE0282204216D522FAB7AE70F8967DD5";
			break;
		case 1603:   //东15左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003173&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=ED5D07195CDD57D9B78BD060184C836C";
			break;
		case 1604:   //东15右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003173&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=D1D8DAA6C8FE3553F597EDEA643FDB24";
			break;

		case 1701:   //东10上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003174&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=9C41A8C9CC4147BC15855EB30637F031";
			break;
		case 1702:   //东10下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003174&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=FCFAB052B9D7D8FA95EC7FB99072EC32";
			break;
		case 1703:   //东10左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003174&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=654182FAB08090AD11F3FA5B19060E75";
			break;
		case 1704:   //东10右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003174&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=656F63914ADA955DFCB86C4588DF89D5";
			break;

		case 1801:   //东11  上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003175&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=FA5FB1C88160A92D7893EFB8AEC1182D";
			break;
		case 1802:   //东11  下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003175&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=CA42331BB30D743AB6EA037F1EEA59D4";
			break;
		case 1803:   //东11  左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003175&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=AF4D611C23D1DEC1C4E719D73647E4BF";
			break;
		case 1804:   //东11  右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003175&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=EBD17FA704A274A465FFB798EBAE7020";
			break;


		case 1901:    //西13上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003176&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=3388849FE403B97A2E42F7F576B0C30E";
			break;
		case 1902:    //西13下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003176&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=8065140708291C0C73B56C6F4E8BAC24";
			break;
		case 1903:    //西13左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003176&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=64F7EC0F626AF971FDCFB4EBCDF6C245";
			break;
		case 1904:    //西13右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003176&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=4A6A92CE9816C546D332D1F9030D88BE";
			break;


		case 2001:   // 东1上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003177&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=D6F18C85F5B88B63CA255E2D962E4B15";
			break;
		case 2002:   // 东1下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003177&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=34DEF1317F06848CD24CB8DE25ECDF58";
			break;
		case 2003:   // 东1左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003177&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=01B9C9E831F88F014D71FEF140EFE15B";
			break;
		case 2004:   // 东1右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003177&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=38AA7E3BB4F8217B1E7BC6B0B3995402";
			break;

		case 2101:   // 东14上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003178&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=514D47EE82AE89EDE329E4E4EEECC508";
			break;
		case 2102:   // 东14下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003178&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=723373A62BCA7302179136431EE61FCD";
			break;
		case 2103:   // 东14左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003178&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=D4CC51A3DB16F6797FBC259FF3873F2A";
			break;
		case 2104:   // 东14右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003178&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=0B2DE5A31DCDCFDFC76F9E6BB7CA781F";
			break;

		case 2201:   // 西4上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003179&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=646F31E43D03BA55B90F9404E6B0611D";
			break;
		case 2202:   // 西4下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003179&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=B8D7E53EFBBC15FC2EDC4037364E4608";
			break;
		case 2203:   // 西4左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003179&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=D6F5665597A3A023144BB9565A31E9BB";
			break;
		case 2204:   // 西4右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003179&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=091A20A7724840EE2B02D4D560AC6919";
			break;





		case 2301:   // 东13  上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003180&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=61FD347424DF92D522E2A7FB29DA642E";
			break;
		case 2302:   // 东13  下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003180&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=F058EE8573FD0CFB594C2819638C5310";
			break;
		case 2303:   // 东13  左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003180&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=54F57B258FA898A85D2172D16A8CAE07";
			break;
		case 2304:   // 东13  右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003180&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=44BB1933DBB5E3AC4DED5C9D48AEA750";
			break;

		case 2401:   // 西1展厅上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003181&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=32250482E37FAF3ABB0091EF6FDADF1D";
			break;
		case 2402:   // 西1展厅下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003181&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=1D9DD2495D40BA548F022F9F4E174887";
			break;
		case 2403:   // 西1展厅左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003181&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=603729624C74A8569F4D47209DCF2B07";
			break;
		case 2404:   // 西1展厅右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003181&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=4CFF32EE23ABFB84BDC3D437EF47228B";
			break;

		case 2501:   // 东6上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003182&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=68986D0A4B576CCE63B19F1FEE94F939";
			break;
		case 2502:   // 东6下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003182&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=433BCA8A5D448E4DBD4D88497A8D1623";
			break;
		case 2503:   // 东6左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003182&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=84B22D7E2E0024450237AA16D3B68E5F";
			break;
		case 2504:   // 东6右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003182&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=4AE7F1E563833FA0E72ECBB1090380E8";
			break;


		case 2601:    //东4上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003183&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=5A354DE4E9355F340D38DEB9F3AE0347";
			break;
		case 2602:    //东4下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003183&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=E79DB32E296A3DA217EC4E3BBCBDD0EA";
			break;
		case 2603:    //东4左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003183&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=B735FE84CB07DBB944A5E9C95E4CD595";
			break;
		case 2604:    //东4右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003183&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=C725D8F2EC894A281AB67C898988C7A9";
			break;



		case 2701:    //西1上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003184&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=5994225EDB15DED9299BC2D41B2E0367";
			break;
		case 2702:    //西1下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003184&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=ED6387FEF8EFD46555CE0DBA2A005304";
			break;
		case 2703:    //西1左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003184&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=7D65C11A6C43F2597E48A217133F2454";
			break;
		case 2704:    //西1右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003184&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=6071575660C45E129C5D75AB4A367FDE";
			break;


		case 2801:    //一楼智慧展厅上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003185&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=95501AF1782868E78B1371A0AB94ACE7";
			break;
		case 2802:    //一楼展厅下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003185&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=08ADC8BE06B3E287AF6212C6B70B73D7";
			break;
		case 2803:    //一楼展厅左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003185&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=FC3F713856DF95EE6507AEB27E7F23C8";
			break;
		case 2804:    //一楼展厅右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003185&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=3C7FE59EFCBBADECE950FA9BBB791D34";
			break;

		case 2901:    //东5
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003186&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=F757E8B705975161A3506F790B73B4FB";
			break;
		case 2902:    //东5
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003186&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=B133C903071EDF3E10E90DE0234728A4";
			break;
		case 2903:    //东5
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003186&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=C6856FA1F2D0B707078D7DB6CCF125DD";
			break;
		case 2904:    //东5
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003186&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=AFD6541A5A14B69E8327D18FCBE6DAC6";
			break;

		case 3001:    //东3 
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003187&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=6BC2BFF1FAFA05CC51B62A131BA76AD3";
			break;
		case 3002:    //东3 
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003187&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=4CC30FB84DB4A731CD3BA7DB7685F3A1";
			break;
		case 3003:    //东3 
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003187&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=10E8FD345DD149308986D435EE5C7D30";
			break;
		case 3004:    //东3 
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003187&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=96A4152311D5466A46078A7CD3E602F4";
			break;


		case 3101:    //西2
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003188&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=3A17E3F16EFDF1A34F1B0B0930D0BDA1";
			break;
		case 3102:    //西2
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003188&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=3A17E3F16EFDF1A34F1B0B0930D0BDA1";
			break;
		case 3103:    //西2
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003188&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=A9F6FD2E24413C107DD1E19AC3AEF79A";
			break;
		case 3104:    //西2
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003188&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=5A4D86F4E5C8CFF6CA08B03C8AA370D2";
			break;

		case 3201:    //3s
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003189&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=2250745B8A63FF7123112A4A893EF594";
			break;
		case 3202:    //3s
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003189&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=D2A101B975AAD42D37E579FE6E9C1264";
			break;
		case 3203:    //3s
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003189&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=FDE5567929A02706E05DD16F265F74B4";
			break;
		case 3204:    //3s
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003189&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=84879A1DAFEF1FD3ABB31F0ED0FC2DBF";
			break;



		case 3301:    //东5走廊
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003190&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=A9BA63444E5283EF1D846CC955F0FD2C";
			break;
		case 3302:    //东5走廊
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003190&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=060F9AB3987416F8FFEB23C20612979F";
			break;
		case 3303:    //东5走廊
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003190&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=BC8DAC44502547B97906A1FC4F088E71";
			break;
		case 3304:    //东5走廊
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003190&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=6202A715763691AD447FE95D1FE7B1E8";
			break;


		case 3401:    //东一展厅
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003191&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=0ECB7DF9170C52EC27F8C198412B4825";
			break;
		case 3402:    //东一展厅
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003191&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=CF76472EE61A849AD980AE977EBBED8E";
			break;
		case 3403:    //东一展厅
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003191&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=579816DF9DEC551268535A6F3D0D0320";
			break;
		case 3404:    //东一展厅
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003191&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=F08888A5B3A72476009595D6ED79CABF";
			break;



		case 3501:    //东七楼走廊
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003192&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=B1961FA24C3907F46E459F28B41ECB1F";
			break;
		case 3502:    //东七楼走廊
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003192&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=2873C17932E33ECC9D21429AB786CA7C";
			break;
		case 3503:    //东七楼走廊
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003192&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=910F574819F8AB8FE3A6860046C1FDD4";
			break;
		case 3504:    //东七楼走廊
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003192&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=7CDCD2762E3CAA68D9017A78263C832E";
			break;

		case 3601:    //西3
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003193&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=9C7FA57A8BFED763588C0B57A4A1EC4D";
			break;
		case 3602:    //西3
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003193&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=92CC9D44380070DACF8A5A755D4CBA5A";
			break;
		case 3603:    //西3
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003193&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=60BBA0DC99F96412C15C4B630669C551";
			break;
		case 3604:    //西3
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003193&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=3F49CB373EFBDCD8579EDCF8D64D37D8";
			break;





		case 3701:    //西8
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003194&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=7554D04BCFE19E80BC832B812A46FF8E";
			break;
		case 3702:    //西8
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003194&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=D943CBCFEE2D9EA1D167F3AE2973D427";
			break;
		case 3703:    //西8
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003194&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=F63CFB2F81C4AA773804B2E00BFFC499";
			break;
		case 3704:    //西8
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003194&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=244665665FE00D7425B97DD4121A2829";
			break;

		case 3801:    //西7楼走廊
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003195&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=C213E8F86A0764A11494CCB44BDF4F8E";
			break;
		case 3802:    //西7楼走廊
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003195&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=8A78E899BD1BD6B5CFE1CC375A8343E0";
			break;
		case 3803:    //西7楼走廊
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003195&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=3591D46D78BAB7718CFF2678A59C0A5C";
			break;
		case 3804:    //西7楼走廊
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003195&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=72561388E7440C0BFA8B2297CEEFA979";
			break;

		case 3901:    //西16
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003196&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=468B8C04B92FDD4C1FD31CCE60D71990";
			break;
		case 3902:    //西16
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003196&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=4ACAD6316530CB2C6FCC8A8DBD6079A3";
			break;
		case 3903:    //西16
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003196&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=6376C28B607795DAEB56686D22652CCF";
			break;
		case 3904:    //西16
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003196&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=060B1F25672134C37A73FB7D15552D7D";
			break;


		case 4001:    // 东2
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003197&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=9E445DF1EF30FE2C0CAED569C52B5907";
			break;
		case 4002:    // 东2
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003197&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=72BC75A72DBDB5A4E965F999DFA4A6E7";
			break;
		case 4003:    // 东2
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003197&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=108EEE8EC7BB4606E1BC6800C930BA2A";
			break;
		case 4004:    // 东2
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003197&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=0862B16BA0ED3F84BA7F4FAB6D667807";
			break;



		case 4101:    // 西6
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003198&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=C49BC54688B6A68135BC66359BA8CD7E";
			break;
		case 4102:    // 西6
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003198&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=127078E8B0AAF21F11A389BB78065A6E";
			break;
		case 4103:    // 西6
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003198&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=A65CF4C4F814EC4FDF0488F9E4E08222";
			break;
		case 4104:    // 西6
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003198&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=04D136BD7ACADFEBEAA6908529D964FA";
			break;


		case 4201:    //东9
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003199&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=D5DE30316F27CF1B663D86C37C4D4E18";
			break;
		case 4202:    //东9
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003199&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=0904AE101E1733C650A2DCE6B61A3B6F";
			break;
		case 4203:    //东9
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003199&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=44320EB66C982B26DAA83FCC4CC3BBE4";
			break;
		case 4204:    //东9
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003199&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=A718A0691545557B8E37453D0E962425";
			break;



		case 4301:    //西7  无
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003200&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=80C2B5F0F2AE5C19B2D7198E9FDE3778";
			break;
		case 4302:    //西7  无
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003200&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=9F1725DB55235A1B43F33C68F0A881F0";
			break;
		case 4303:    //西7  无
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003200&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=256F52E362D6EF346F2DC1B19CFDACD2";
			break;
		case 4304:    //西7  无
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003200&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=7E448162ED993010C348E2B6B410BAF9";
			break;


		case 4401:    //西五工程中心
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003201&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=A92424AA4B6224D02F84B6D64AC448DC";
			break;
		case 4402:    //西五工程中心
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003201&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=04CCA0CAEAD3359969585B6D8CB9774A";
			break;
		case 4403:    //西五工程中心
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003201&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=8D0D0E11C4790FF08DA21A41E7300DB9";
			break;
		case 4404:    //西五工程中心
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003201&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=B27227EDB8483BC44E9363D512909218";
			break;


		case 4501:    //五楼
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003202&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=74F6D2A95A8B807810FF422B9B809AA2";
			break;
		case 4502:    //五楼
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003202&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=7B5A1483E70464A1DF7E63E524D3FEDF";
			break;
		case 4503:    //五楼
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003202&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=767D252ADF93FADC2C52E6D883FFFF45";
			break;
		case 4504:    //五楼
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003202&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=BCB321378631894479A8873DA1657B43";
			break;




		case 4601:    // 东16楼
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003203&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=0B0C4EFE281A21624ACA9F9F3F788079";
			break;
		case 4602:    // 东16楼
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003203&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=AB5B04842663140B48F62998717F50C2";
			break;
		case 4603:    // 东16楼
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003203&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=05DFE68E30E519422BDCF52532F8223F";
			break;
		case 4604:    // 东16楼
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003203&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=C4930893CEC4DC82CBDDCEB6AE0DCD58";
			break;



		case 4701:    //草坪
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003210&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=2CB6F512D5AF688A4C4809A4370DBFF2";
			break;
		case 4702:    //草坪
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003210&channelNo=0&ptzDirection=21&opTime=2015-10-14%2020:00:00&opkey=88488E0DAD9024925FDE0608FD9D6CA4";
			break;
		case 4703:    //草坪
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003210&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=C2F2A98C00E24CEACB7D4794EC847C0D";
			break;
		case 4704:    //草坪
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003210&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=BAF365AD64D02B96E47F083EDED79DBF";
			break;

		case 4801:    //南门上
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003211&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=1881FD885A9E713D39FCA83C0910D615";
			break;
		case 4802:    //南门下
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003211&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=E336C8DDE2897247BAFF88CAB40451A3";
			break;
		case 4803:    //南门左
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003211&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=33D60B3D282216AFA9C61FE8FF3530F4";
			break;
		case 4804:    //南门右
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003211&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=B9C32A59A151B3E8DCC93CFCF7522088";
			break;

		case 4901:    //门外
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003212&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=AF6B6A0E70B92465D2B3CA8EE98259E7";
			break;
		case 4902:    //门外
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003212&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=87D60D85EBD1AE6C32D21554B0E96288";
			break;
		case 4903:    //门外
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003212&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=5458C01ED6341AEAFD825EFFA854ADFE";
			break;
		case 4904:    //门外
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003212&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=0412F62CD8AD5F138B14B1CBE31FA599";
			break;


		case 5001:    //一楼大厅内
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003214&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=DB069C7774CF0498617B09C9E7C648D3";
			break;
		case 5002:    //一楼大厅内
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003214&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=46C22B21B6FA5C1D326EC444EAE6D6C8";
			break;
		case 5003:    //一楼大厅内
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003214&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=2DF1C25EFA6AAD8E9492C0D586D6391F";
			break;
		case 5004:    //一楼大厅内
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003214&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=788745A057A7C538244D9619BE4FF589";
			break;


		case 5101:    //七楼会议室内屏幕
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003215&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=9BAE7B63DD0823375F8A5E40BD1C108B";
			break;
		case 5102:    //七楼会议室内屏幕
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003215&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=B72824F2288938CE23961DD872C6EBFA";
			break;
		case 5103:    //七楼会议室内屏幕
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003215&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=FC5B8CFF696E425A2E8DA29843AEC460";
			break;
		case 5104:    //七楼会议室内屏幕
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003215&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=1BD9D096F394B32CEF3FA0F7B97B4E17";
			break;


		case 5201:    //七楼会议室大门
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003216&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=72E7D39FC53586DB1BF5D3138BBC902B";
			break;	
		case 5202:    //七楼会议室大门
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003216&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=DF7550BA589BCD5EA4411AD288EBF786";
			break;	
		case 5203:    //七楼会议室大门
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003216&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=7F5A22072C20CFBCF7C242D0E31F3E4C";
			break;	
		case 5204:    //七楼会议室大门
			url_get="http://112.25.191.156:8083/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100003216&channelNo=0&ptzDirection=3&opTime=2015-10-14%2020:00:00&opkey=7F5A22072C20CFBCF7C242D0E31F3E4C";
			break;	


		case 5301:    //展厅测试机
			url_get="http://117.27.144.28:9084/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100000734&channelNo=0&ptzDirection=1&opTime=2015-10-14%2020:00:00&opkey=4A0E880EC00204E8CAE9E8B556B4A7F1";
			break;
		case 5302:    //展厅测试机
			url_get="http://117.27.144.28:9084/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100000734&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=A8CDA230A269234BE0CCE7E0C6C61127";
			break;
		case 5303:    //展厅测试机
			url_get="http://117.27.144.28:9084/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100000734&channelNo=0&ptzDirection=2&opTime=2015-10-14%2020:00:00&opkey=A8CDA230A269234BE0CCE7E0C6C61127";
			break;
		case 5304:    //展厅测试机
			url_get="http://117.27.144.28:9084/appIntf/ptzAction?appID=201509210001&account=18950296635&devID=90100000734&channelNo=0&ptzDirection=4&opTime=2015-10-14%2020:00:00&opkey=22063EC9FE10144B228DE9C816786490";
			break;
		}
		Log.e("<<<<>>>>>>", url_get);
		
		String response=new String();
		SyncHttpRequestService syncHttpRequestService=new SyncHttpRequestService();
		response=syncHttpRequestService.httpGet(url_get, null);
		Log.e("<<<<<<>>>>>", response);
		return response;
	}

	
}
