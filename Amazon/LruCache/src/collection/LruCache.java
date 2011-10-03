package collection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LruCache<K, V> {

	private final Map<K, V> cache;
	private final int maxSize;

	public LruCache(final int maxSize) {
		if (maxSize <= 0) {
			throw new IllegalArgumentException("cache size should >= 1");
		}
		this.maxSize = maxSize;
		this.cache = mapImpl(maxSize);
	}

	private LinkedHashMap<K, V> mapImpl(final int maxSize) {
		return new LinkedHashMap<K, V>(maxSize, 0.75f, false) {
			private static final long serialVersionUID = -6442279163688940304L;

			@Override
			protected boolean removeEldestEntry(Entry<K, V> eldest) {
				return size() > LruCache.this.maxSize;
			}
		};
	}

	public V put(K key, V value) {
		if (key == null || value == null) {
			throw new NullPointerException("key or value can not be null");
		}
		synchronized (this) {
			return cache.put(key, value);
		}
	}

	public V get(K key) {
		if (key == null) {
			throw new NullPointerException("key can not be null");
		}
		
		V value;
		synchronized (this) {
			value = cache.get(key);
			if (value != null) {
				return value;
			}

			value = create(key);
			cache.put(key, value);
			return value;
		}

	}
	
	public synchronized int size(){
		return cache.size();
	}

	protected V create(K key) {
		return null;
	}
}
