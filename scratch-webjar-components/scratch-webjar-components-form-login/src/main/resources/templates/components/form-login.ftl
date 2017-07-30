<#import "../formLogin.ftl" as f>
<link rel="import" href="/webjars/polymer/1.8.0/polymer.html">

<dom-module id="form-login">
    <link rel="import" type="css" href="/css/input-text.css">
    <link rel="import" type="css" href="/css/input-password.css">
    <template>
    <@f.formLogin/>
    </template>

    <script>
        Polymer({
            is: 'form-login'
        });
    </script>
</dom-module>