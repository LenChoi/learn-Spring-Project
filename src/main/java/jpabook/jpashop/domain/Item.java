package jpabook.jpashop.domain;

import jpabook.jpashop.exception.NotEoughtStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<Category>();

    //==비지니스 로직==// setter 대신에 메서드를 통해서 값을 변경해야한다. 이게 가장 객체지향적

    /**
     * stock 증
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }
    /**
     * stock 감소
    */

    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEoughtStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}