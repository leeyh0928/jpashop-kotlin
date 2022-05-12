package com.jpabook.jpashop.domain.entity.item

import javax.persistence.*

@Entity
@Table(name = "categories")
class CategoryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    var id: Long? = null,

    var name: String,

    @ManyToMany
    @JoinTable(
        name = "category_item_mappings",
        joinColumns = [JoinColumn(name = "category_id")],
        inverseJoinColumns = [JoinColumn(name = "item_id")]
    )
    var items: MutableList<ItemEntity> = mutableListOf(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    var parent: CategoryEntity? = null,

    @OneToMany(mappedBy = "parent")
    var child: MutableList<CategoryEntity> = mutableListOf()
) {
}