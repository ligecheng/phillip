package com.util;

import java.util.TreeMap;

import com.entity.Product;

public class Node {
	//访问到当前节点是否为一个单词
	public Boolean isWord;
	
	//以当前字符结尾的单词个数
	public Integer endCount;
	
	public Product product;
	
	//商品名字
	public String word = "";
	public TreeMap<Character,Node> next;
	public Node(Boolean isWord) {
		this.isWord = isWord;
		endCount = 0;
		next = new TreeMap();
	}
	public Node() {
		this(false);
		endCount = 0;
	}
}
