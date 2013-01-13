package com.astralplanelabs.eulerproject.common

/**
 *
 * User: jtempleton
 *
 **/
trait CommonLib {

  def flatMapSublists[A,B](ls: List[A])(f: (List[A]) => List[B]): List[B] =
    ls match {
      case Nil => Nil
      case sublist@(_ :: tail) => f(sublist) ::: flatMapSublists(tail)(f)
    }

  /***************************************************
    *
    * Take this flat list, create x number of combos
    * of pairs, triplets
    *
    * @param flatList
    * @param numOfCombos (Pairs, Triplets, etc)
    * @return
    ***************************************************/
  def combinations[A](n: Int, ls: List[A]): List[List[A]] =
    if (n == 0) List(Nil)
    else flatMapSublists(ls) { sl =>
      combinations(n - 1, sl.tail) map {sl.head :: _}
    }

}
