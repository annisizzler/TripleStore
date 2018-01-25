package org.apache.jena.examples;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.model.vocabulary.FOAF;
import org.eclipse.rdf4j.model.vocabulary.RDF;
//import org.apache.jena.rdf.model.RDFNode;
//import org.apache.jena.rdf.model.Resource;
import org.eclipse.rdf4j.model.Statement;
//import org.apache.jena.rdf.model.StmtIterator;
//import org.apache.jena.util.FileManager;

public class TripleStoreDemo {

	public void demo(String[] args) {

		// We use a ValueFactory to create the building blocks of our RDF statements: IRIs, blank nodes
		// and literals.
		ValueFactory vf = SimpleValueFactory.getInstance();

		// We want to reuse this namespace when creating several building blocks.
		String ex = "http://example.org/";

		// Create IRIs for the resources we want to add.
		IRI picasso = vf.createIRI(ex, "Picasso");
		IRI artist = vf.createIRI(ex, "Artist");

		// Create a new, empty Model object.
		Model model = new TreeModel();

		// add our first statement: Picasso is an Artist
		model.add(picasso, RDF.TYPE, artist);

		// second statement: Picasso's first name is "Pablo".
		model.add(picasso, FOAF.FIRST_NAME, vf.createLiteral("Pablo"));

		// to see what's in our model, let's just print it to the screen
		for(Statement st: model) {
			System.out.println(st);
		}
	}	
}