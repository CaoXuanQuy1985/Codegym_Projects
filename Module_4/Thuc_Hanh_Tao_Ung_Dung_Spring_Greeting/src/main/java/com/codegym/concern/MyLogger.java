package com.codegym.concern;

import com.codegym.model.BadWord;
import com.codegym.model.LogTable;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Aspect
@Transactional
public class MyLogger {
    static Logger log = Logger.getLogger(MyLogger.class);

    @PersistenceContext
    private EntityManager em;

    public void error() {
        System.out.println("[com.codegym] ERROR !");
    }

    @AfterThrowing(pointcut = "execution(public * com.codegym.service.*.*(..))", throwing = "ex")
    public void log(JoinPoint joinPoint, Exception ex) {
        TypedQuery<BadWord> query = em.createQuery("select b from BadWord b", BadWord.class);
        TypedQuery<LogTable> query_2 = em.createQuery("select b from LogTable b", LogTable.class);
        List<BadWord> badWordList = query.getResultList();
        List<LogTable> badWordList_2 = query_2.getResultList();

        LogTable lastItem = badWordList_2.get(badWordList_2.size() - 1);
        System.out.println("author: " + lastItem.getAuthor() + " feedback: " + lastItem.getContent()
                                    + "DateTime: " + lastItem.getDateTime());

        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        System.out.println(String.format("[Application] co loi xay ra: %s.%s%s: %s", className, method, args, ex.getMessage()));
    }
}
