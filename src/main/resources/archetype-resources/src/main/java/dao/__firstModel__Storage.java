#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import ${package}.model.${firstModel};

public interface ${firstModel}Storage {

    ${firstModel} store(${firstModel} item);
    ${firstModel} getById(String id);
    boolean delete(String id);

}
