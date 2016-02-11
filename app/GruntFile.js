'use strict';//Chay strict mode

module.exports = function(grunt) {
    // Project configuration
    grunt.initConfig({
        pkg : grunt.file.readJSON('package.json'),
        app : {
            source : 'src/main/webapp/resources/',
            desc : 'src/main/webapp/resources/'
        },
        concat:{
            css: {
                src: [ '<%=app.source%>**/css/page/*.css','<%=app.source%>**/css/component/*.css' ],
                dest: '<%=app.desc%>assets/css/temp.css'
            }
        },
        cssmin:{
            css: {
                src: [ '<%=app.desc%>assets/css/temp.css' ],
                dest: '<%=app.desc%>assets/css/app.css'
            }
        },
        uglify: {
            nenjs: {
               src: ['<%=app.source%>assets/js/page/login.js'],
               dest: '<%=app.desc%>assets/js/page/login.min.js',
            }
         }
    });

    grunt.loadNpmTasks("grunt-contrib-concat");
    grunt.loadNpmTasks("grunt-contrib-cssmin");
    grunt.loadNpmTasks("grunt-contrib-uglify");

    grunt.registerTask('build', ['concat:css','cssmin:css','uglify:nenjs']);
    grunt.registerTask('default', ['build']);
};