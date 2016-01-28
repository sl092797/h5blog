<#include "head.ftl">
    <div style="height: 25px"></div>
    <div style="background: url(${CCB_BASE_PATH}/images/20130111-00-04.png) repeat-x bottom">
        <span style="font-size: 12px; font-weight: 700; color: #002b61; padding: 0px 0px 0px 110px;">预付卡</span>
    </div>
    <div style="background: url(${CCB_BASE_PATH}/images/20130111-00-02.png) repeat-x center; width: 500px; height: 30px; float: right">
    </div>
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
                                        <td style="padding-top:12px" align="center" valign="top"><span class="content-title" style="font-size: 13px">卡片激活</span></td>
                                        <td valign="top">
                                            <table width="100%" border="0" cellspacing="2" cellpadding="0">
                                                <tr>
                                                    <td width="61%" height="90">
                                                        <form action="./toActive" name="activeForm" method="post">
                                                            <input type="hidden" name="Language" value="1" />
                                                            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                                                                <tr>
                                                                    <td>
                                                                        <table border="0" cellpadding="0" cellspacing="2">
                                                                            <tr>
                                                                                <td align="right" height="30"><span class="table-content">卡号:</span></td>
                                                                                <td width="170" align="left" height="30">
                                                                                    <input type="text" name="j_username" value=${userName} readonly="readonly" style="width: 150px; height: 15px;" />
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td align="right" height="30"><span class="table-content">密码:</span></td>
                                                                                <td align="left">
                                                                                    <input type="password" maxlength="6" id='static_pin' style="width: 150px; height: 15px;" />
                                                                                    <input type="hidden" name="encPin" value="" />
                                                                                </td>
                                                                                <td align="left" height="30"><span style="font-size: 13px; color: #006BB6;">印于预付卡背面</span>
                                                                                </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td align="right">&nbsp;</td>
                                                                                <td colspan="3" align="left">
                                                                                    <table border="0" cellpadding="0" cellspacing="0">
                                                                                        <tr>
                                                                                            <td height="30" style="padding-left: 40px">
                                                                                                <span class="button0" onclick="f_check()">提交</span>
                                                                                            </td>
                                                                                        </tr>
                                                                                    </table>
                                                                                </td>
                                                                            </tr>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                            <input type="hidden" name="PublicKeyN" value="${PublicKeyN}" />
                                                            <input type="hidden" name="PublicKeyE" value="${PublicKeyE}" />
                                                        </form>
                                                    </td>
                                                </tr>
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
