<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>Will Sell Insurance for Food</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <style type="text/css">
        [ng\:cloak], [ng-cloak], [data-ng-cloak], [x-ng-cloak], .ng-cloak, .x-ng-cloak {
            display: none !important;
        }
    </style>

    <asset:stylesheet src="application.css"/>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

    <script type="text/javascript">
        window.contextPath = "${request.contextPath}";
    </script>
    <script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>

    <!-- Bootflat's JS files.-->
    <script src="https://bootflat.github.io/bootflat/js/icheck.min.js"></script>
    <script src="https://bootflat.github.io/bootflat/js/jquery.fs.selecter.min.js"></script>
    <script src="https://bootflat.github.io/bootflat/js/jquery.fs.stepper.min.js"></script>
</head>

<body ng-app="blockheads" ng-controller="IndexController as indexCtrl">


    <div class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" ng-click="navExpanded = !navExpanded">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/#">
                    <i class="fa grails-icon">
                    </i> WSIFF
                </a>
            </div>


            <div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;" uib-collapse="!navExpanded">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown" uib-dropdown>
                        <a href="#" class="dropdown-toggle" uib-dropdown-toggle role="button" aria-haspopup="true" aria-expanded="false">Application Status <span class="caret"></span></a>
                        <ul class="dropdown-menu" uib-dropdown-menu>
                            <li><a href="#">Environment: {{indexCtrl.applicationData.environment}}</a></li>
                            <li><a href="#">App profile: {{indexCtrl.applicationData.appprofile}}</a></li>
                            <li><a href="#">App version: {{indexCtrl.applicationData.appversion}}</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Grails version: {{indexCtrl.applicationData.grailsversion}}</a></li>
                            <li><a href="#">Groovy version: {{indexCtrl.applicationData.groovyversion}}</a></li>
                            <li><a href="#">JVM version: {{indexCtrl.applicationData.jvmversion}}</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Reloading active: {{indexCtrl.applicationData.reloadingagentenabled}}</a></li>
                        </ul>
                    </li>
                    %{--<li class="dropdown" uib-dropdown>--}%
                        %{--<a href="#" class="dropdown-toggle" uib-dropdown-toggle role="button" aria-haspopup="true" aria-expanded="false">Artefacts <span class="caret"></span></a>--}%
                        %{--<ul class="dropdown-menu" uib-dropdown-menu>--}%
                            %{--<li><a href="#">Controllers: {{indexCtrl.applicationData.artefacts.controllers}}</a></li>--}%
                            %{--<li><a href="#">Domains: {{indexCtrl.applicationData.artefacts.domains}}</a></li>--}%
                            %{--<li><a href="#">Services: {{indexCtrl.applicationData.artefacts.services}}</a></li>--}%
                        %{--</ul>--}%
                    %{--</li>--}%
                    %{--<li class="dropdown" uib-dropdown>--}%
                        %{--<a href="#" class="dropdown-toggle" uib-dropdown-toggle role="button" aria-haspopup="true" aria-expanded="false">Installed Plugins <span class="caret"></span></a>--}%
                        %{--<ul class="dropdown-menu" uib-dropdown-menu>--}%
                            %{--<li ng-repeat="plugin in indexCtrl.applicationData.plugins"><a href="#">{{plugin.name}} - {{plugin.version}}</a></li>--}%
                        %{--</ul>--}%
                    %{--</li>--}%
                </ul>
            </div>
        </div>
    </div>
<ol class="breadcrumb breadcrumb-arrow">
    <li><a href="#">Welcome</a></li>
    <li><a href="#">User Name</a></li>
    <li><a href="#">Personal Info</a></li>
    <li><a href="#">Offers</a></li>
    <li class="active"><span>Data</span></li>
</ol>
<ul class="pager">
    <li class="previous"><a href="#">Previous</a></li>
    <li class="next disabled"><a href="#">Next</a></li>
</ul>

<div class="pricing">
    <ul>
        <li class="unit price-primary">
            <div class="price-title">
                <h3>$299</h3>
                <p>per month</p>
            </div>
            <div class="price-body">
                <h4>Basic</h4>
                <p>Lots of clients &amp; users</p>
                <ul>
                    <li>250 SKU's</li>
                    <li>1 GB Storage</li>
                    <li>3,5% transaction fee</li>
                </ul>
            </div>
            <div class="price-foot">
                <button type="button" class="btn btn-primary">Try a Week</button>
            </div>
        </li>
        <li class="unit price-success active">
            <div class="price-title">
                <h3>$499</h3>
                <p>per month</p>
            </div>
            <div class="price-body">
                <h4>Premium</h4>
                <p>Lots of clients &amp; users</p>
                <ul>
                    <li>2500 SKU's</li>
                    <li>5 GB Storage</li>
                    <li>1,5% transaction fee</li>
                </ul>
            </div>
            <div class="price-foot">
                <button type="button" class="btn btn-success">Buy Now</button>
            </div>
        </li>
        <li class="unit price-warning">
            <div class="price-title">
                <h3>$599</h3>
                <p>per month</p>
            </div>
            <div class="price-body">
                <h4>Unlimited</h4>
                <p>Lots of clients &amp; users</p>
                <ul>
                    <li>Unlimited SKU's</li>
                    <li>20 GB Storage</li>
                    <li>1% transaction fee</li>
                </ul>
            </div>
            <div class="price-foot">
                <button type="button" class="btn btn-warning">Subscribe</button>
            </div>
        </li>
    </ul>
</div>

<div class="progress">
    <div class="progress-bar progress-bar-success" style="width: 40%">40%</div>
    <div class="progress-bar progress-bar-warning" style="width: 25%">25%</div>
</div>

    <div ui-view></div>

    <div class="footer" role="contentinfo"></div>

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>

    <asset:javascript src="/blockheads/blockheads.js" />
    <!-- <script type="javascript" src="static/javascript/vendor/app.min.js"/> <!-- the contract/web3 js -->
</body>
</html>
