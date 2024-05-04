package Pegas.mapper;

public interface Mapper<F, T>{
    T fromTo(F f);
    default T fromTo(F f, T t){
        return t;
    }
}
