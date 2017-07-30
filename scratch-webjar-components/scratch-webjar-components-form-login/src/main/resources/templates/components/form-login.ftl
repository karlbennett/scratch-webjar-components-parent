<#import "../formLogin.ftl" as f>
<link rel="import" href="/webjars/polymer/1.8.0/polymer.html">

<dom-module id="form-login">
    <template>
    <@f.formLogin/>
    </template>

    <script>
        Polymer({
            is: 'form-login'
        });
    </script>
</dom-module>