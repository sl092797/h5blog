<#include "head.ftl">
    <div id="trustpaddiv" onmousedown="showDiv()" style="position: absolute; left: 10px; top: 20px; width: 150px; height: 94px; z-index: 0; visibility: hidden">
        <form id="trustpadform" target="hiddenframe" style="DISPLAY: none" action="">
            <input id="ActiveXStatus" type="hidden" value="N" />
        </form>
        <table cellpadding="0" cellspacing="0">
            <tr>
                <td align="left">
                    <table cellpadding="0" cellspacing="0">
                        <tr>
                            <td></td>
                        </tr>
                        <tr>
                            <td colspan="2" id="ObjectContent" align="left">
                                <object id='TrustPadX' name='TrustPadX' classid='clsid:1975B11A-F0CF-4AB2-A65A-F7768E0B0718' codebase='../../scripts/SecPad.CAB#version=1,0,0,2' width='156' height='94'> </object>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </div>
    <div style="height: 25px"></div>
    <div style="background: url(${CCB_BASE_PATH}/images/20130111-00-04.png) repeat-x bottom">
        <span style="font-size: 12px; font-weight: 700; color: #002b61; padding: 0px 0px 0px 110px;">预付卡</span>
    </div>
    <div style="background: url(${CCB_BASE_PATH}/images/20130111-00-02.png) repeat-x center; width: 500px; height: 30px; float: right"></div>
    <table cellspacing="0" cellpadding="0" style="width: 100%;">
        <tbody>
            <tr>
                <td style="width: 257px;" valign="top">
                    <#include "left.ftl">
                </td>
                <td style="width: 5px" valign="top"><img src="${CCB_BASE_PATH}/images/20130111-00-13.png"></img>
                </td>
                <td valign="top">
                    <table>
                        <tr>
                            <td>
                                <table>
                                    <tr>
                                        <td><span class="content-title" style="padding: 50px; white-space: nowrap;">预付卡</span>
                                        </td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td height="25px" colspan="2"></td>
                                    </tr>
                                    <tr>
                                        <#include "righthead.ftl">
                                    </tr>
                                    <tr>
                                        <td colspan="2" style="padding: 20px 20px"><img src="${CCB_BASE_PATH}/images/20130111-00-05.png"></img>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="padding-top:12px" align="center" valign="top"><span class="content-title" style="font-size: 13px">坏卡处理</span></td>
                                        <td valign="top" class="content-paragraph" style="padding-top:12px">
                                            <div class="right-content">
                                                <p>
                                                    感谢选用建设银行(亚洲)预付卡,若阁下发现预付卡于多个商户都未能成功使用,请阁下依照以下程序亲临香港建设银行(亚洲)分行办理退款手续。
                                                </p>
                                                <ul style="padding:0px 30px">
                                                    <li style="list-style-type:square;">步骤1:由于分行办理退款手续会收取阁下手续费, 请先查明阁下尚有可用余额,才亲临分行办理退款手续。
                                                    </li>
                                                    <li style="list-style-type:square;">步骤2: 阁下需要带同香港身份证明文件或有效旅行证件于预付卡到期日前亲临香港建设银行(亚洲)分行办理退款手续。请注意,每一位客人每天只能办理一张预付卡之退款。
                                                    </li>
                                                    <li style="list-style-type:square;">步骤3: 建设银行(亚洲)分行职员经核实后,会协助阁下填写退款手续表格, 并只退回現金。
                                                    </li>
                                                </ul>
                                                <p>
                                                    本行并保留有关退款之最终决定权。如要查询香港建设银行(亚洲)分行地址,请浏览本行网页www.asia.ccb.com
                                                </p>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </tbody>
    </table>
    </div>
    <#include "foot.ftl">
        </body>

        </html>
