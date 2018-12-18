package org.bzc.comicstore.utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.bzc.comicstore.beans.Item;

public class Cart implements Serializable {

	/* Private Fields */

	private final Map itemMap = Collections.synchronizedMap(new HashMap());
	private final List itemList = new ArrayList();

	/* JavaBeans Properties */

	public List getCartItemList() {
		return itemList;
	}

	public int getNumberOfItems() {
		
		return itemList.size();
	}

	/* Public Methods */
    // �鿴�����Ƿ��Ծ��ڹ��ﳵ�����
	public boolean containsItemId(String itemId) {
		return itemMap.containsKey(itemId);
	}

	// ���ﳵ�������Ʒ �õ��� itemMap ��itemList ��itemMap��Ҫ�Ƿ���ȡ��item
	public void addItem(Item item, boolean isInStock) {
		CartItem cartItem = (CartItem) itemMap.get(item.getItemid());
		if (cartItem == null) {
			cartItem = new CartItem();
			cartItem.setItem(item);
			cartItem.setQuantity(0);
			cartItem.setInStock(isInStock);
			itemMap.put(item.getItemid(), cartItem);
			itemList.add(cartItem);
		}
		cartItem.incrementQuantity();
	}

	// �ӹ��ﳵ���Ƴ���Ʒ������

	public void removeItemById(String itemId) {
		CartItem cartItem = (CartItem) itemMap.remove(itemId);
		if (cartItem == null) {
			return;
		} else {
			itemList.remove(cartItem);
		}
	}

	// �Զ�������Ʒ������
	public void incrementQuantityByItemId(String itemId) {
		CartItem cartItem = (CartItem) itemMap.get(itemId);
		cartItem.incrementQuantity();
	}

	// ���id���� ��Ʒ������
	public void setQuantityByItemId(String itemId, int quantity) {
		CartItem cartItem = (CartItem) itemMap.get(itemId);
		cartItem.setQuantity(quantity);
	}

	// ��ȡ���ﳵ��Ʒ���ܼ�Ǯ
	public BigDecimal getSubTotal() {
		BigDecimal subTotal = new BigDecimal("0");
		Iterator items = getAllCartItems();
		while (items.hasNext()) {
			CartItem cartItem = (CartItem) items.next();
			Item item = cartItem.getItem();
			BigDecimal listPrice = item.getListprice();
			BigDecimal quantity = new BigDecimal(String.valueOf(cartItem
					.getQuantity()));
			subTotal = subTotal.add(listPrice.multiply(quantity));
		}
		return subTotal;
	}

	public Iterator getCartItems() {
		return itemList.iterator();

	}

	public Iterator getAllCartItems() {
		List allItems = new ArrayList();

		allItems.addAll(itemList);

		return allItems.iterator();
	}
	
	 public void updateCartQuantities(Map parameterMap) {
		    Iterator cartItems =this.getAllCartItems();
		    while (cartItems.hasNext()) {
		      CartItem cartItem = (CartItem) cartItems.next();
		      String itemId = cartItem.getItem().getItemid();
		      try {
		        int quantity = Integer.parseInt((String) parameterMap.get(itemId));
		        this.setQuantityByItemId(itemId, quantity);
		        if (quantity < 1) {
		          cartItems.remove();
		        }
		      } catch (Exception e) {
		        // ignore on purpose
		      }
		    }
		 
		 
	 }
		   

}
