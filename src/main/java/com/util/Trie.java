package com.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import com.entity.Product;
@Component
public class Trie{
	
	//树根
	private Node root;
	//树节点数量
	private Integer size;
	
	private List<Product> productList = new ArrayList<>();
	
	public Trie() {
		root  = new Node();
		size = 0;

	}
	

	
	public Integer getSize() {return size;}
	
	//向字典种加入单词
	public void push(String word,Product product) {
		if(word == null || word.equals("")) 
			throw new IllegalArgumentException("Word cannot be null");
		pushImpl(root,word,0,product);
	}
	
	private void pushImpl(Node pNode,String word,Integer index,Product product) {
		if(index == word.length()) {
			//如果当前字符是单词最后一个字符(Node)，如果当前字符不是其他单词的结尾就将当前字符设置为当前要插入单词的的结尾
			if(!pNode.isWord) {
				pNode.isWord = true;
				pNode.word = word;
				pNode.product = product;
				size ++;
				pNode.endCount += 1;
			}else {
				pNode.endCount += 1;
			}
			return;
		}
		
		char ch = word.charAt(index);
		//如果当前节点的下一个节点没有ch字符(Node),在当前节点创建一个ch节点
		if(pNode.next.get(ch) == null) {
			pNode.next.put(ch, new Node());
		}
		pushImpl(pNode.next.get(ch),word,index + 1,product);
		
	}
	
	//在字典种查找单词(单词不存在字典中就去查库，之后将其加入到字典中)
	public Boolean contains(String word) {
		Node cur = root;
		for( int i = 0;i < word.length();i ++ ) {
			char ch = word.charAt(i);
			//如果当前节点的下一个节点没有word单词中其中一个字符，即当前单词不存在字典中
			if(cur.next.get(ch) == null)
				return false;
			cur = cur.next.get(ch);
		}
		return true;
	}
	
	//从字典中获取单词
	public String getWord(String word) {
		Node cur = root;
		char str[] = new char[word.length()];
		for( int i = 0;i < word.length();i ++ ) {
			char ch = word.charAt(i);
			if(cur.next.get(ch) == null) {
				return null;
			}
			str[i] = ch;
			cur = cur.next.get(ch);
		}
		return str.toString();
	}
	
	//匹配规则，例子: pand* --> 星号表示以pand开头的字符串
	@SuppressWarnings("unchecked")
	public List<Product> match(String string){
		//将上次匹配到的结果清空
		if(productList != null) {
			productList = null;
			productList = new ArrayList<>();
		}
		search(root,string+"*",0);
		return productList == null ? Collections.EMPTY_LIST : productList;
	}

//	private boolean search (Node pNode,String word,int index){
//        if(index == word.length())
//            return pNode.isWord;
//        char ch = word.charAt(index);
//        if(ch != '.'){
//            if(pNode.next.get(ch) == null)
//                return false;
//            return search(pNode.next.get(ch),word,index+1);
//        }
//        else{
//            for(char nextChar:pNode.next.keySet()){
//                if(search(pNode.next.get(nextChar),word,index+1)){
//                    return true;
//                }
//            }
//            return false;
//        }
//
//    }
	
	private void search(Node pNode,String string,Integer index) {
	
		char ch = string.charAt(index);
		if( ch != '*') {
			if(pNode.next.get(ch) == null)
				return ;
			search(pNode.next.get(ch),string,index + 1);
		}else {
			string = string.substring(0, string.length()-1);
			searchImpl(pNode,string);
		}

		
	}
	
	private void searchImpl(Node pNode,String string) {
		
		if (pNode != null) {

			for (Character nextChar : pNode.next.keySet()) {
				if (pNode.next.get(nextChar).isWord) {
					
					Product product = pNode.next.get(nextChar).product;
					String targetWord = pNode.next.get(nextChar).word;
					String tmpString = targetWord.substring(0, string.length());
					if (tmpString.equals(string) || string.equals(targetWord)) {
						this.productList.add(product);
					}
				} else
					searchImpl(pNode.next.get(nextChar), string);
			}
		}
	

	}
	
	//索引整个字典
	public void preTraverse() {
		preTraverseImpl(root);
	}
	private void preTraverseImpl(Node pNode) {
		if(pNode != null) {
			for(Character nextChar : pNode.next.keySet()) {
				if(pNode.next.get(nextChar).isWord) 
					System.out.println(pNode.next.get(nextChar).word);
				else
					preTraverseImpl(pNode.next.get(nextChar));
			}
		}
	}
	
}
