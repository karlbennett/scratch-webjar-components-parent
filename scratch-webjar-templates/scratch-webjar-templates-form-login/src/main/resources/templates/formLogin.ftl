<#import "form.ftl" as f>
<#import "inputText.ftl" as it>
<#import "inputPassword.ftl" as ip>
<#macro formLogin>
    <@f.form button="Login">
        <@it.inputText label="Email" name="email"/>
        <@ip.inputPassword label="Password" name="password"/>
    </@f.form>
</#macro>