<#macro pageLogin email>
<div class="login">
    <#if email?has_content>
        <a class="header-email" href="/profile">${email}</a>
        <a class="header-logout" href="/logout">Logout</a>
    <#else>
        <a class="header-register" href="/registration">Register</a>
        <a class="header-login" href="/login">Login</a>
    </#if>
</div>
</#macro>