package collection.test;
import static org.junit.Assert.*;
import org.junit.Test;

import collection.LruCache;

public class LruCacheTest {

	@Test
	public void testCacheShouldNotOverflow() {
		
		LruCache<String, String> cacheTen = new LruCache<String, String>(10);
		for (int i = 1; i < 100; i++) {
			cacheTen.put(String.valueOf(i), String.valueOf(i));
		}
		
		assertEquals(10, cacheTen.size());
	}

	@Test
	public void testEviction() {
		LruCache<String, String> cache = new LruCache<String, String>(10);

		for (int i = 1; i < 11; i++) { // 1..10
			cache.put(String.valueOf(i), String.valueOf(i));
		}
		
		for (int i = 10; i > 1; i--) { // access 10...2
			cache.get(String.valueOf(i));
		}
		
		cache.put(String.valueOf(11), String.valueOf(11));
		assertNull(cache.get(String.valueOf(1))); // 1 should be
															// evicted
	}
	
	@Test
	public void testCacheMiss(){
		LruCache<String, String> cache = new LruCache<String, String>(1){

			@Override
			protected String create(String key) {
				return key+"'s value";
			}
			
		};
		
		String value = cache.get("key");
		
		assertNotNull(value);
		assertEquals("key's value", value);
		
	}
	
	@Test
	public void testEvictionOrder() {
		LruCache<String, String> cache = new LruCache<String, String>(3);

		cache.put("One", "One");
		cache.put("Two", "Two");
		cache.put("Three", "Three");
		
		cache.get("One");
		cache.get("Three");
		cache.get("Two");
		
		assertEquals(cache.put("One", "One1"),"One");
		assertEquals(cache.put("Three", "Three3"),"Three");
		assertEquals(cache.put("Two", "Two2"),"Two");
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeMaxSize() {
		new LruCache<String, String>(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testZeroMaxSize() {
		new LruCache<String, String>(0);
	}
	
	@Test(expected = NullPointerException.class)
	public void testNullPut() {
		new LruCache<String, String>(1).put(null, null);
	}
	
	@Test(expected = NullPointerException.class)
	public void testNullGet() {
		new LruCache<String, String>(1).get(null);
	}
	
	@Test
	public void testValidMaxSize() {
		new LruCache<String, String>(110);
	}
}
