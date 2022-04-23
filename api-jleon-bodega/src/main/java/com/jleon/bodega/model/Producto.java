package com.jleon.bodega.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "producto")
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Producto implements Serializable{
	
	private static final long serialVersionUID = -6875535997440898462L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;
	private String producto;
	private String descripcion;
	private Double precio;
	private Integer stock;
	
	@OneToMany(mappedBy = "producto")
	private List<Bodega> listBodega = new ArrayList<>();
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="producto_cliente",
	joinColumns = @JoinColumn(name="id_producto", nullable = false, unique = true,foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_producto) references producto (id_producto)")),
	inverseJoinColumns =  @JoinColumn(name="id_cliente", nullable = false, unique = true,foreignKey 
	= @ForeignKey(foreignKeyDefinition = "foreign key (id_cliente) references cliente (id_cliente)"))
	)
	private List<Cliente> listClientes = new ArrayList<>();

}
