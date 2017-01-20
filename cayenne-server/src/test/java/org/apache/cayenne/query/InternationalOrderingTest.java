package org.apache.cayenne.query;

import java.text.Collator;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test Ordering using collators. 
 */

public class InternationalOrderingTest {

	private static final Person nullName = new Person( null );
	private static final Person aðalsteinn = new Person( "Aðalsteinn" );
	private static final Person áki = new Person( "Áki" );
	private static final Person hugi = new Person( "Hugi" );
	private static final Person óðinn = new Person( "Óðinn" );
	private static final Person ögmundur = new Person( "Ögmundur" );

	private static final List<Person> ORIGINAL_LIST = Arrays.asList( óðinn, hugi, aðalsteinn, nullName, ögmundur, áki );
	private static final List<Person> EXPECTED_ORDER_WITHOUT_COLLATOR = Arrays.asList( nullName, aðalsteinn, hugi, áki, óðinn, ögmundur );
	private static final List<Person> EXPECTED_ORDER_WITH_ICELANDIC_COLLATOR = Arrays.asList( nullName, aðalsteinn, áki, hugi, óðinn, ögmundur );

	@Before
	public void ensureDefaultCollatorIsNull() {
		Ordering.setDefaultCollator( null );
	}

	@Test
	public void orderingWithoutCollator() {
		Ordering ordering = new Ordering("name");

		assertNull( Ordering.defaultCollator );
		assertNull( ordering.collator );
		assertEquals(EXPECTED_ORDER_WITHOUT_COLLATOR, ordering.orderedList( ORIGINAL_LIST ) );
	}

	@Test
	public void orderingWithCollatorSetForInstance() {
		Ordering ordering = new Ordering("name");
		ordering.setCollator( Collator.getInstance(new Locale("is")) );

		assertNull( Ordering.defaultCollator );
		assertEquals( Collator.getInstance(new Locale("is")), ordering.collator );
		assertEquals(EXPECTED_ORDER_WITH_ICELANDIC_COLLATOR, ordering.orderedList( ORIGINAL_LIST ) );
	}
	
	@Test
	public void orderingWithDefaultCollator() {
		Ordering.setDefaultCollator(Collator.getInstance(new Locale("is")));
		Ordering ordering = new Ordering("name");

		assertEquals( Collator.getInstance(new Locale("is")), Ordering.defaultCollator );
		assertEquals( Collator.getInstance(new Locale("is")), ordering.collator );
		assertEquals(EXPECTED_ORDER_WITH_ICELANDIC_COLLATOR, ordering.orderedList( ORIGINAL_LIST ) );
	}
	
	public static class Person {

		private String name;

		public Person(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + "]";
		}
	}
}