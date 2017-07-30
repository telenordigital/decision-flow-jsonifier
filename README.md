# Decision Flow Jsonifier

* [How to go about](#how-to-go-about)

This utility is complementary to decision-flow library, and may be used to speed up loading
 of decision flows.

Some of the UML tools (like Visual Paradigm) produce large XML files that may take up to
15-20 seconds to load. This may slow down application startups and particularly unit tests. 
One may therefore want to convert such files in a less verbose format, like Json. 

Hence the utility. 

## How to go about?

Clone this repo, cd to its local directory and build it:

	# git clone <url to this repo>
	# cd decision-flow-jsonifier
	# mvn package
	
Suppose you have exported a Visual Paradigm decision diagram to a file in XMI format. In 
order to perform a conversion to Json, do the following:
	
	# java -jar target/decision-flow-jsonifier.jar -visualparadigm path/to/xmi > path/to/json

Now, you can use JsonDescriber to load the diagram rather than VisualParadigm:

	DecisionFlowDescriber describer = JsonDescriber.getInstance(
                    new String(Files.readAllBytes(Paths.get("path/to/json"))));
    DecisionMachine decisionMachine = DecisionFlow.getInstance(describer);

