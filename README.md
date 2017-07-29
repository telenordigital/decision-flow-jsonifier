# Decision Flow Jsonifier

* [How to go about](#how-to-go-about)

This utility is complementary to decision-flow library, and may be used to speed up loading
 of decision flows.

Some of the UML tools (like Visual Paradigm) produce large XML files that may take up to
15-20 seconds to load. This may slow down application startups and particularly unit tests. 
One may therefore want to convert such files in a less verbose format, like Json. 

Hence the utility. 

## How to go about?

Clone this repo, cd to its local directory, build and execute it once:

	# git clone <url to this repo>
	# cd decision-flow-jsonifier
	# mvn package
	# java -jar target/decision-flow-jsonifier.jar
	
Follow the instructions from the usage output.

