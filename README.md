The Forked project:
I'm playing with an old project for fun. 
- Convert it to a maven project
	- [More info](https://fleshandmachines.wordpress.com/2018/04/07/freespaceopen-installer-improvement-or-how-to-mavenize-an-old-ant-based-project/ ) 
- Update it with unit /function test
- Continous test feature

To create the FreeSpaceOpenInstaller.jar please run:

mvn install 

and find it under ${project}/target

To run unit test from console:

mvn test

To run unit test from eclipse:
Right click on the test classes that you want to run and Run as > TestNG test

Thanks for the original project!

The original project:

https://github.com/scp-fs2open/fsoinstaller

# fsoinstaller
The Java installer for FS2_Open and the collection of mods from the Hard Light Productions community.

See also readme.txt in the docs/ folder.