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
			    '<%= paths.js %>/app.min.js',
				'<%= paths.js %>/app.min.js.map',
				'<%= paths.css %>/app.min.css'
			],
			build: 'build'
		},
		
		//Minify javascript files
		uglify : {
			dev : {
				options: {
                    mangle      : true,
                    compres     : true,
                    sourceMap   : '<%= paths.js %>/app.min.map'
                },
                src: [
                      '<%= paths.build.js %>/app.js'
                ],
                dest: '<%= paths.js %>/app.min.js'
			},
			prod: {
				options: {
                    mangle      : true,
                    compres     : true,
                    sourceMap   : false
                },
                src: [
                    '<%= paths.build.js %>/app.js'
                ],
                dest: '<%= paths.js %>/app.min.js'
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
                    '<%= paths.assets.js %>/app.js'
                ]
            }
        },
        
        // Less to css, all less files MUST import to app.less.
        less: {
            less_compile: {
                files: {
                    '<%= paths.css %>/app.css': [
                        '<%= paths.assets.less %>/page/landing/*.less'
                    ]
                }
            }
        },
        
        // Concat files.
        concat: {
            css: {
                src: [
                    '<%= paths.assets.vendor %>/bootstrap/dist/css/bootstrap.css',
                    '<%= paths.assets.vendor %>/fontawesome/css/font-awesome.css',
                    '<%= paths.assets.vendor %>/animatecss/css/animate.css',
                    '<%= paths.assets.vendor %>/checkbox3/dist/checkbox3.css',
                    '<%= paths.assets.vendor %>/normalize-css/normalize.css',
                    '<%= paths.assets.vendor %>/tether/dist/css/tether.css',
                    '<%= paths.assets.css %>/app.css'
                ],
                dest: '<%= paths.build.css %>/app.css'
            },
            js: {
                options: {
                    seperator: ';',
                    banner: "/* up4d Software 2015 */\n"
                },
                src: [
                    '<%= paths.assets.vendor %>/jquery/dist/jquery.js',
                    '<%= paths.assets.vendor %>/tether/dist/js/tether.js',
                    '<%= paths.assets.vendor %>/bootstrap/dist/js/bootstrap.js',
                    '<%= paths.assets.js %>/app.js'
                ],
                dest: '<%= paths.build.js %>/app.js'
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
                    '<%= paths.assets.css %>/app.comb.css': ['<%= paths.assets.css %>/app.css']
                }
            }
        },

        cssmin: {
            target: {
                files: {
                    '<%= paths.css %>/app.min.css': ['<%= paths.build.css %>/app.css']
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
