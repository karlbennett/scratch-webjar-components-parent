<#macro header email>
<div class="header-container">
    <div class="login">
        <#if email?has_content>
            <a class="header-email" href="/profile">${email}</a>
            <a class="header-logout" href="/logout">Logout</a>
        <#else>
            <a class="header-register" href="/registration">Register</a>
            <a class="header-login" href="/login">Login</a>
        </#if>
    </div>
    <div class="menu">
        <a href="/">Home</a>
    </div>
</div>
</#macro>