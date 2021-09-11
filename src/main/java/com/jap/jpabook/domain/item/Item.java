package com.jap.jpabook.domain.item;

import com.jap.jpabook.domain.Category;
import com.jap.jpabook.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype")
public class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    //business logic
    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }

    public void removeStorck(int quantity){
        int restStock = this.stockQuantity - quantity;
        if(restStock <0 ){
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
