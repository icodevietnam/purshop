require.config({
	shim : {
        "bootstrap" : { "deps" :['jquery'] },
        "bootstrapswitch" : {"deps" : ['bootstrap']},
        "jquery_match_height" : {"deps" : ['jquery']},
        "dashboard" : { "deps" : ['bootstrapswitch','jquery_match_height']}
    },
	paths:{
		jquery : "vendors/jquery/dist/jquery.min",
		undescore: "vendors/underscore-amd/underscore-min",
		angular: "vendors/angular/angular.min",
		bootstrap : "vendors/bootstrap/dist/js/bootstrap.min",
		bootstrapswitch : "vendors/bootstrap-switch/dist/js/bootstrap-switch.min",
		jquery_match_height : "vendors/jquery-matchheight/jquery.matchHeight-min",
		dashboard : "js/admin/dashboard/dashboard"
	}
});

requirejs(["dashboard"],function(){
});