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
                                        <td style="padding-top:12px" align="center" valign="top"><span class="content-title" style="font-size: 13px">交易查询</span></td>
                                        <td valign="top">
                                            <table style="Border-spacing:10px 5px">
                                                <#if tis??>
                                                    <thead>
                                                        <tr>
                                                            <td class="table-header" colspan="4">最多可显示最近10笔交易 (按 日/月/年 显示)</td>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <#list tis as ti>
                                                            <tr>
                                                                <td class="table-content">${ti.workDate}</td>
                                                                <td class="table-content" style="width:250px">${ti.shopName}</td>
                                                                <td class="table-content" style="width:100px">${ti.tranDesc}</td>
                                                                <td class="table-content">${ti.currTrans}</td>
                                                                <td class="table-content">${ti.amtTrans}</td>
                                                            </tr>
                                                        </#list>
                                                        <#else>
                                                            <tr>
                                                                <td height="30" class="table-content">您没有进行交易</td>
                                                            </tr>
                                                </#if>
                                                </tbody>
                                            </table>
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
