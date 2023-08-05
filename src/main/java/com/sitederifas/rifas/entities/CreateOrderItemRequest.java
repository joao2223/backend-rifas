package com.sitederifas.rifas.entities;

public class CreateOrderItemRequest {

    private Long orderId;
    private Long raffleId;
    private Integer quantity;
    private Double price;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getRaffleId() {
		return raffleId;
	}
	public void setRaffleId(Long raffleId) {
		this.raffleId = raffleId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
