<#import "layout.ftl" as m>
<#import "form.ftl" as f>
<@m.layout title="Freemarker (Login)" heading="Login">
    <@f.form button="Login">
        <@f.inputText label="Email" name="email"/>
        <@f.inputPassword label="Password" name="password"/>
    </@f.form>
</@m.layout>