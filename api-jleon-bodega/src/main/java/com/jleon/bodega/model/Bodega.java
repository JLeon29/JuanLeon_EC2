package com.jleon.bodega.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "bodega")
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bodega implements Serializable {

	private static final long serialVersionUID = 3261158348737420583L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBodega;
	private String nombre;
	private String direccion;

	@ManyToOne
	@JoinColumn(name="id_producto", nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition 
			= "foreign key (id_producto) references producto (id_producto)"))
	private Producto producto;
}
