仍以spittr这个应用为例，通过配置XML文件来搭建Spring MVC

——看到iA4第7章时决定自己走走看这条路

1.新建maven项目，选的ArtifactID是maven-archetype-webapp 1.0（An archetype which contains a sample Maven Webapp project.）建好项目先--右击项目--build path--add libraries，加tomcat7那套

2.按照印象笔记将项目改为dynamic web module 3.0，java版本1.8
标题【终断-SSM-Cannot change version of project facet Dynamic web module to 3.0】或网址【http://www.cnblogs.com/tf-Y/p/4928897.html】。已经做好，并把.settings也加进了git，所以你下次不用再改。

3.到目前为止，（把所有多余的都注释掉，只留springmvc的XML配置文件、home相关的控制器和视图）部署在tomcat7上可以成功访问 "/" 看到home视图。

2017.08.06 01:03
4.其实新建的项目什么都不用改...dynamic web module 2.3 & jre 1.5 同样能正常运行...艹

2017.08.07
5.把 .gitignore 也托管上去
6.mac系统的.DS_Store文件用印象笔记里积累的方式全局忽略