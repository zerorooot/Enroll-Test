<%--
  Created by IntelliJ IDEA.
  User: msj10
  Date: 2019/12/24
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" style="background-color: white; transition: background-color 0.15s ease 0s;"
      class="ss-shaded-scrollbars">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><%
        try {
            out.print(application.getAttribute("subject").toString());
        } catch (Exception e) {
            out.print("活动还没有开始！!");
        }
    %>活动报名</title>

    <meta name="viewport" content="width=device-width, minimum-scale=1, maximum-scale=1,user-scalable=no">
    <meta name="format-detection" content="telephone=no">

    <meta name="applicable-device" content="mobile">
    <meta name="robots" content="noindex">

    <script type="text/javascript" async="" charset="utf-8" src="./enroll_files/core.php"></script>
    <script src="./enroll_files/hm.js.下载"></script>
    <script type="text/javascript">
        var maxCheatTimes = 0;
        var activityId = 49980905;
        if (window.location.hash) {
            window.location.hash = "";
            window.location.href = window.location.href.replace("#", "");
        }
        var isWeiXin = 0;
    </script>
    <link rel="stylesheet" href="./enroll_files/jqmobo.css">

    <script src="./enroll_files/jquery.min.js.下载"></script>

    <script type="text/javascript">
        !window.jQuery && document.write('&lt;script src="/js/jquery-1.10.2.min.js">&lt;\/script>');
    </script>

    <script src="./enroll_files/hintinfo.js.下载" type="text/javascript"></script>

    <script src="./enroll_files/jqmobo2.js.下载" type="text/javascript"></script>

    <style>


    </style>


</head>
<body style="">

<div id="divTip"
     style="position:absolute; left: 0; right: 0; z-index: 10; display: none; font-size: 14px; color: #ffffff; line-height: 24px; padding: 8px; background-color: #f95b5b;"></div>
<div id="tipHeight" style="height:40px;display:none;"></div>
<div style="background: #fff; position: fixed; top: 0px; left: 0px; right: 0px; bottom: 0px; z-index: 2; display: none;"
     id="divWorkError">
</div>

<form id="form1" method="post" action="EnrollServlet" style="overflow:hidden;">

    <div id="divLoadAnswer"
         style="display: none; font-size: 14px;line-height:24px;padding:6px 8px;background-color: #fff9f0;">

    </div>

    <div id="toptitle">
        <h1 class="htitle" id="htitle">
            <%
                try {
                    out.print(application.getAttribute("subject").toString());
                } catch (Exception e) {
                    out.print("<h1>活动还没有开始！！</h1>");
                    return;
                }
            %>活动报名</h1>
    </div>


    <div id="divBackgroundWrap"></div>
    <div id="divMaxTime"
         style="display: none; background: #FFEAEA; color: #FF5760; font-size: 16px; height: 40px; left: 0; line-height: 40px; position: fixed; text-align: center; top: 0; width: 100%; z-index: 100;">
        <span id="spanTimeTip"></span>&nbsp;<span id="spanMaxTime"></span>
    </div>

    <div id="divContent" class="divContent">
        <div class="checkInMode__head clearfix" id="divCheckInMode" style="display: none;">
            <div class="wjxCountDown__wrap game_time">
                <div class="countDown__hold">
                    <div class="round round1"></div>
                </div>
                <div class="countDown__hold">
                    <div class="round round2"></div>
                </div>
                <div class="countDown__bg"></div>
                <div class="CountDown__frame"></div>
                <div class="countDown__time">
                    <div class="countDown__time--num" id="divCGMaxTime">10</div>
                    <div class="countDown__time--unit">秒</div>
                </div>
            </div>
            <div class="icon decoration-icon pull-left"></div>
            <div class="schedule-wrap pull-right">
                <div id="schedule">1</div>
                / <span id="cgtotal">5</span>题
            </div>
        </div>


        <div id="divQuestion">
            <fieldset class="fieldset" style="" id="fieldset1">
                <!-- 姓名-->
                <div class="field ui-field-contain" id="div1" topic="1" data-role="fieldcontain" type="1">
                    <div class="field-label">1.您孩子的姓名</div>
                    <div class="ui-input-text" style="position:relative;">
                        <input type="text" id="q2" value="" name="name"></div>
                    <div class="errorMessage"></div>
                </div>
                <!--年纪-->
                <div class="field ui-field-contain" id="div2" req="1" topic="2" data-role="fieldcontain" type="3">
                    <div class="field-label">2. 您孩子的年纪<span class="req">*
                        </span></div>
                    <div class="ui-controlgroup">
                        <div class="ui-radio"><span class="jqradiowrapper">
                        <input type="radio" value="一年级"  name="grade" style="display:none;"><a
                                class="jqradio" href="javascript:;">
                        </a></span>
                            <div class="label">一年级</div>
                        </div>

                        <div class="ui-radio"><span class="jqradiowrapper">
                        <input type="radio" value="二年级"  name="grade" style="display:none;"><a
                                class="jqradio" href="javascript:;">
                        </a></span>
                            <div class="label">二年级</div>
                        </div>

                        <div class="ui-radio"><span class="jqradiowrapper">
                        <input type="radio" value="三年级"  name="grade" style="display:none;"><a
                                class="jqradio" href="javascript:;">
                        </a></span>
                            <div class="label">三年级</div>
                        </div>

                        <div class="ui-radio"><span class="jqradiowrapper">
                        <input type="radio" value="四年级"  name="grade" style="display:none;"><a
                                class="jqradio" href="javascript:;">
                        </a></span>
                            <div class="label">四年级</div>
                        </div>

                        <div class="ui-radio"><span class="jqradiowrapper">
                        <input type="radio" value="五年级"  name="grade" style="display:none;"><a
                                class="jqradio" href="javascript:;">
                        </a></span>
                            <div class="label">五年级</div>
                        </div>

                        <div class="ui-radio"><span class="jqradiowrapper">
                        <input type="radio" value="六年级"  name="grade" style="display:none;"><a
                                class="jqradio" href="javascript:;">
                        </a></span>
                            <div class="label">六年级</div>
                        </div>
                    </div>

                    <div class="errorMessage"></div>
                </div>
                <!-- 性别-->
                <div class="field ui-field-contain" id="div3" req="1" topic="3" data-role="fieldcontain" type="3">
                    <div class="field-label">3. 您孩子的姓别<span class="req">*
                        </span></div>
                    <div class="ui-controlgroup">

                        <div class="ui-radio"><span class="jqradiowrapper">
                        <input type="radio" value="男"  name="gender" style="display:none;"><a
                                class="jqradio" href="javascript:;">
                        </a></span>
                            <div class="label" >男</div>
                        </div>

                        <div class="ui-radio"><span class="jqradiowrapper">
                        <input type="radio" value="女" name="gender" style="display:none;"><a
                                class="jqradio" href="javascript:;">
                    </a></span>
                            <div class="label" >女</div>
                        </div>
                    </div>
                    <div class="errorMessage"></div>
                </div>

                <div class="field ui-field-contain" id="div4" topic="4" data-role="fieldcontain" type="1">
                    <div class="field-label">4.您的联系方式</div>
                    <div class="ui-input-text" style="position:relative;">
                        <input type="text"  value="" name="tele"></div>
                    <div class="errorMessage"></div>
                </div>

            </fieldset>
        </div>
        <div id="divMatrixHeader" class="divMatrixHeader"
             style="position: absolute; display: none; font-size: 12px; color: #333">
        </div>
        <div class="shopcart" id="shopcart" style="display: none;">
        </div>

        <div class="footer">
            <div class="ValError" id="ValError">
            </div>
            <div id="captchaOut">
                <div id="captchaWrap">
                    <span id="captchaTit" style="display:none;color:#42B917;"></span>
                    <div id="captcha" style="margin: 0 auto;"></div>
                </div>
            </div>

            <div id="divSubmit" style="padding: 0px 20px 10px;">

                <div class="voteDiv">
                    <!--                        <a id="ctlNext" href="javascript:;" class="button blue"> 提交</a>-->
                    <input type="submit" class="button blue">
                </div>
            </div>

            <a href="javascript:;" id="cgstartbutton" style="display: none;"></a>

            <div id="divSearch"
                 style="background: #020d15; color: #7c7c7c; font-size: 18px; height: 50px; left: 0; line-height: 50px; position: fixed; text-align: center; bottom: 0; width: 100%; z-index: 100; display: none;">
            </div>

        </div>

    </div>


    <div id="divTimeUp" style="display: none;">
        <div style="padding: 10px; overflow: auto; line-height: 20px; font-size: 16px; text-align: center;"
             id="divTimeUpTip"></div>
    </div>
</form>

<a id="lnkCity" style="display: none;"></a>


<script type="text/javascript">
    var needAvoidCrack = 0;
    var tdCode = "tdCode";
    var imgCode = $("#imgCode")[0];
    var submit_text = $("#yucinput")[0];
    var tCode = $("#" + tdCode)[0];
    var hasTouPiao = 0

</script>


<div style="display: none;">
    <script src="./enroll_files/z_stat.php" language="JavaScript" async=""
            onload="if(window.loadCzc)loadCzc();"></script>
    <script>var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?21be24c80829bd7a683b2c536fcf520b";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();</script>
</div>

</body>
<screen-shader
        style="display: block; transition: none 0s ease 0s; margin: 0px; padding: 0px; border-radius: 0px; border: none; outline: none; visibility: visible; max-height: none; max-width: none; clip: unset; overflow: visible; opacity: 1;">
    <!--This is an element that contains all the html for the screen shader extension to work-->
    <div style="display: block; transition: none 0s ease 0s; margin: 0px; padding: 0px; border-radius: 0px; border: none; outline: none; visibility: visible; max-height: none; max-width: none; clip: unset; overflow: visible; opacity: 0; position: fixed; top: -10%; right: -10%; bottom: -10%; left: -10%; width: auto; height: auto; z-index: 2147483646; background: black;"></div>
    <div style="display: block; transition: none 0s ease 0s; margin: 0px; padding: 0px; border-radius: 0px; border: none; outline: none; visibility: visible; max-height: none; max-width: none; clip: unset; overflow: visible; opacity: 1; position: fixed; top: -10%; right: -10%; bottom: -10%; left: -10%; width: auto; height: auto; z-index: 2147483645; background: rgba(255, 147, 41, 0.153); mix-blend-mode: multiply;"></div>
    <style>screen-shader {
        pointer-events: none !important;
    }</style>
    <style>
        :root.ss-shaded-scrollbars::-webkit-scrollbar {
            background: rgb(241, 225, 210) !important;
            width: 17px !important;
            height: 17px !important;
            -webkit-appearance: unset !important;
        }

        :root.ss-shaded-scrollbars::-webkit-scrollbar-track {
            background: transparent !important;
        }

        :root.ss-shaded-scrollbars::-webkit-scrollbar-corner {
            background: rgb(210, 196, 183) !important;
            box-shadow: none !important;
            border-radius: unset !important;
        }

        :root.ss-shaded-scrollbars::-webkit-scrollbar-thumb {
            background: rgb(193, 181, 168) !important;
            border: 2px solid rgb(241, 225, 210) !important;
            box-shadow: none !important;
            border-radius: unset !important;
        }

        :root.ss-shaded-scrollbars::-webkit-scrollbar-thumb:vertical {
            border-bottom-width: 0 !important;
            border-top-width: 0 !important;
        }

        :root.ss-shaded-scrollbars::-webkit-scrollbar-thumb:horizontal {
            border-left-width: 0 !important;
            border-right-width: 0 !important;
        }

        :root.ss-shaded-scrollbars::-webkit-scrollbar-thumb:hover {
            background: rgb(168, 157, 147) !important;
        }

        :root.ss-shaded-scrollbars::-webkit-scrollbar-thumb:active {
            background: rgb(120, 112, 105) !important;
        }

        :root.ss-shaded-scrollbars::-webkit-scrollbar-button {
            background-color: rgb(241, 225, 210) !important;
            background-repeat: no-repeat !important;
            background-position: center !important;
            box-shadow: none !important;
            border-radius: unset !important;
        }

        :root.ss-shaded-scrollbars::-webkit-scrollbar-button:active {
            background-color: rgb(120, 112, 105) !important; /* also arrow image should be white */
        }

        :root.ss-shaded-scrollbars::-webkit-scrollbar-button:hover {
            background-color: rgb(210, 196, 183) !important;
        }


        :root.ss-shaded-scrollbars::-webkit-scrollbar-button:vertical:decrement {
            background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAcAAAAECAYAAABCxiV9AAAAVUlEQVQYV2NkgIJlM3tEmFjY9//789MxKr3kDUiYESa5Yu7k3QwMDC4MDAx7IpJzXeGSK+dNXvz/P0MMTCEjI8OS8KTcWMaV8yZ3///PUAKTQFLQAwAsExlqCWOVZgAAAABJRU5ErkJggg==) !important;
        }

        :root.ss-shaded-scrollbars::-webkit-scrollbar-button:vertical:increment {
            background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAcAAAAECAYAAABCxiV9AAAAWElEQVQYV2NcOW9y9///DCUMaICRkaGHESS2ct7kxf//M8TA5BkZGZaEJ+XGgiVBYMXcybsZGBhcGBgY9kQk57qCxOCSy2b2iDCxsO//9+enY1R6yRuQJACDVxlqZ2W0xQAAAABJRU5ErkJggg==) !important;
        }

        :root.ss-shaded-scrollbars::-webkit-scrollbar-button:horizontal:decrement {
            background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAQAAAAHCAYAAAAvZezQAAAAPUlEQVQYV2NkQAIr503uZoTxV86bvPj/f4YYxmUze0SYWNiXMzAwuIAkGVfMnXyZgYFBB6YSUwWGGei2AABCAxcFFiLu7wAAAABJRU5ErkJggg==) !important;
        }

        :root.ss-shaded-scrollbars::-webkit-scrollbar-button:horizontal:increment {
            background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAQAAAAHCAYAAAAvZezQAAAAOElEQVQYV2NcOW9yd3hSbikDFDCumDv5PyMjw5LwpNxYkBhYACq559+fn5HIAiDxK9hVoJiBbgsAfSgjcb86f1gAAAAASUVORK5CYII=) !important;
        }
    </style>
    <html style="display: block; transition: none 0s ease 0s; margin: 0px; padding: 0px; border-radius: 0px; border: none; outline: none; visibility: visible; max-height: none; max-width: none; clip: unset; overflow: visible; opacity: 1; position: fixed; top: -10%; right: -10%; bottom: -10%; left: -10%; width: auto; height: auto; z-index: -2147483647;"></html>
    <div style="display: block; transition: none 0s ease 0s; margin: 0px; padding: 0px; border-radius: 0px; border: none; outline: none; visibility: visible; max-height: none; max-width: none; clip: unset; overflow: visible; opacity: 1; position: fixed; top: -10%; right: -10%; bottom: -10%; left: -10%; width: auto; height: auto; z-index: -2147483646; background: none 0% 0% / auto repeat scroll padding-box border-box rgb(255, 255, 255);"></div>
</screen-shader>
</html>
