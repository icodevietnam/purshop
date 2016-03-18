'use strict';//Chay strict mode

module.exports = function (grunt) {
	grunt.initConfig({
		//Path variables
		paths: {
			//Development where put LESS files, etc
			assets: {
				path  : 'src/main/webapp/resources/assets',
				css   : '<%= paths.assets.path %>/css',	
				js    : '<%= paths.assets.path %>/js',	
				less  : '<%= paths.assets.path %>/less',
				vendor: '<%= paths.assets.path %>/vendors'	
			},
			
			build: {
				css	  : '<%= paths.assets.path %>/build/css',
				js	  : '<%= paths.assets.path %>/build/js'
			},
			
			// Production where Grunt output the files
			css		  :'<%= paths.assets.css %>',
			js		  :'<%= paths.assets.js %>'
		},
		
		// Clean asset files
		clean:	{
			assets: [
			    '<%= paths.assets.js %>/admin.min.js',
				'<%= paths.assets.js %>/admin.min.js.map',
				'<%= paths.assets.css %>/admin.min.css'
			],
			build: 'build'
		},
		
		//Minify javascript files
		uglify : {
			dev : {
				options: {
                    mangle      : true,
                    compres     : true,
                    sourceMap   : '<%= paths.assets.js %>/admin.min.map'
                },
                src: [
                      '<%= paths.build.js %>/admin.js'
                ],
                dest: '<%= paths.assets.js %>/admin.min.js'
			},
			prod: {
				options: {
                    mangle      : true,
                    compres     : true,
                    sourceMap   : false
                },
                src: [
                    '<%= paths.build.js %>/admin.js'
                ],
                dest: '<%= paths.assets.js %>/admin.min.js'
			}
		},
		
		//Coding guidelines
		jshint: {
			src: [''],
			options: {
                unused: false
            },
            target: {
                src: [
                    '<%= paths.assets.js %>/admin.js'
                ]
            }
        },
        
        // Less to css, all less files MUST import to admin.less.
        less: {
            less_compile: {
                files: {
                    '<%= paths.assets.css %>/admin.css':'<%= paths.assets.less %>/admin/*.less'
                },
                home:{
                	'<%= paths.assets.css %>/home.css':'<%= paths.assets.less %>/home/*.less'
                }
            }
        },
        
        // Concat files.
        concat: {
            css: {
                src: [
                    '<%= paths.assets.vendor %>/bootstrap/dist/css/bootstrap.css',
                    '<%= paths.assets.vendor %>/bootstrapswitch/dist/css/bootstrap3/bootstrap-switch.css',
                    '<%= paths.assets.vendor %>/fontawesome/css/font-awesome.css',
                    '<%= paths.assets.vendor %>/animatecss/css/animate.css',
                    '<%= paths.assets.vendor %>/checkbox3/dist/checkbox3.css',
                    '<%= paths.assets.vendor %>/normalize-css/normalize.css',
                    '<%= paths.assets.vendor %>/tether/dist/css/tether.css',
                    '<%= paths.assets.vendor %>/datatables/media/css/jquery.dataTables.css',
                    '<%= paths.assets.vendor %>/datatables/media/css/dataTables.bootstrap.css',
                    '<%= paths.assets.vendor %>/select2/dist/css/select2.css',
                    '<%= paths.assets.css %>/style.css',
                    '<%= paths.assets.css %>/themes/flat-blue.css',
                    '<%= paths.assets.css %>/admin.css'
                ],
                dest: '<%= paths.build.css %>/admin.css'
            },
            js: {
                options: {
                    seperator: ';',
                    banner: "/* purshop Software 2015 */\n"
                },
                src: [
                    '<%= paths.assets.vendor %>/jquery/dist/jquery.js',
                    '<%= paths.assets.vendor %>/bootstrap/dist/js/bootstrap.js',
                    '<%= paths.assets.vendor %>/Chart/Chart.js',
                    '<%= paths.assets.vendor %>/jquery-match-height/dist/jquery.matchHeight.js',
                    '<%= paths.assets.vendor %>/datatables/media/js/jquery.dataTables.js',
                    '<%= paths.assets.vendor %>/datatables/media/js/dataTables.bootstrap.js',
                    '<%= paths.assets.vendor %>/bootstrapswitch/dist/js/bootstrap-switch.js',
                    '<%= paths.assets.vendor %>/select2/dist/js/select2.full.js',
                    '<%= paths.assets.js %>/admin.js'
                ],
                dest: '<%= paths.build.js %>/admin.js'
            }
        },
        
        // Watch change
        watch: {
            scripts: {
                files: ['<%= paths.assets.js %>'],
                tasks: ['jshint']
            },
            css: {
                files: ['<%= paths.assets.css %>/*.css'],
                tasks: ['default']
            }
        },

        csscomb: {
            dist: {
                files: {
                    '<%= paths.assets.css %>/admin.comb.css': ['<%= paths.assets.css %>/admin.css']
                }
            }
        },

        cssmin: {
            target: {
                files: {
                    '<%= paths.assets.css %>/admin.min.css': ['<%= paths.build.css %>/admin.css']
                }
            }
        }

	});
	
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-csscomb');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-contrib-less');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-cssmin');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    
    grunt.registerTask('build',['clean:assets','less', 'concat', 'uglify:prod', 'csscomb', 'cssmin']);
    grunt.registerTask('default',['build']);
    /*grunt.registerTask('prod', ['jshint', 'clean:assets', 'less', 'concat', 'uglify:prod', 'csscomb', 'cssmin', 'clean:build']);*/
}
