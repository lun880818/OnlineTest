CREATE DATABASE  IF NOT EXISTS `onlinetest` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `onlinetest`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: onlinetest
-- ------------------------------------------------------
-- Server version	8.0.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Temporary view structure for view `studentdata`
--

DROP TABLE IF EXISTS `studentdata`;
/*!50001 DROP VIEW IF EXISTS `studentdata`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `studentdata` AS SELECT 
 1 AS `studentNO`,
 1 AS `school`,
 1 AS `grade`,
 1 AS `name`,
 1 AS `gender`,
 1 AS `username`,
 1 AS `password`,
 1 AS `phone`,
 1 AS `teacherNo`,
 1 AS `teacherName`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `havendonetest`
--

DROP TABLE IF EXISTS `havendonetest`;
/*!50001 DROP VIEW IF EXISTS `havendonetest`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `havendonetest` AS SELECT 
 1 AS `id`,
 1 AS `testno`,
 1 AS `suject`,
 1 AS `questionOrder`,
 1 AS `questionNo`,
 1 AS `eachScore`,
 1 AS `teacherNo`,
 1 AS `studentNo`,
 1 AS `time`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `testgroupbytestno`
--

DROP TABLE IF EXISTS `testgroupbytestno`;
/*!50001 DROP VIEW IF EXISTS `testgroupbytestno`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `testgroupbytestno` AS SELECT 
 1 AS `testNo`,
 1 AS `suject`,
 1 AS `questionSum`,
 1 AS `scoreSum`,
 1 AS `teacherNo`,
 1 AS `studentNo`,
 1 AS `teacherTime`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `answerdata`
--

DROP TABLE IF EXISTS `answerdata`;
/*!50001 DROP VIEW IF EXISTS `answerdata`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `answerdata` AS SELECT 
 1 AS `id`,
 1 AS `testno`,
 1 AS `questionOrder`,
 1 AS `answer`,
 1 AS `answerTime`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `testresult`
--

DROP TABLE IF EXISTS `testresult`;
/*!50001 DROP VIEW IF EXISTS `testresult`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `testresult` AS SELECT 
 1 AS `testno`,
 1 AS `teacherno`,
 1 AS `studentno`,
 1 AS `suject`,
 1 AS `questionorder`,
 1 AS `questionNo`,
 1 AS `topic`,
 1 AS `correctAnswer`,
 1 AS `answer`,
 1 AS `eachScore`,
 1 AS `score`,
 1 AS `answerTime`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `testdata`
--

DROP TABLE IF EXISTS `testdata`;
/*!50001 DROP VIEW IF EXISTS `testdata`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `testdata` AS SELECT 
 1 AS `testno`,
 1 AS `suject`,
 1 AS `questionorder`,
 1 AS `questionNo`,
 1 AS `correctAnswer`,
 1 AS `eachScore`,
 1 AS `teacherno`,
 1 AS `teacherName`,
 1 AS `studentNo`,
 1 AS `studentName`,
 1 AS `time`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `questionalldata`
--

DROP TABLE IF EXISTS `questionalldata`;
/*!50001 DROP VIEW IF EXISTS `questionalldata`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `questionalldata` AS SELECT 
 1 AS `id`,
 1 AS `questionno`,
 1 AS `suject`,
 1 AS `grade`,
 1 AS `topic`,
 1 AS `optionA`,
 1 AS `optionB`,
 1 AS `optionC`,
 1 AS `optionD`,
 1 AS `correctAnswer`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `testresultgroupbytestno`
--

DROP TABLE IF EXISTS `testresultgroupbytestno`;
/*!50001 DROP VIEW IF EXISTS `testresultgroupbytestno`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `testresultgroupbytestno` AS SELECT 
 1 AS `testNo`,
 1 AS `teacherNo`,
 1 AS `studentNo`,
 1 AS `suject`,
 1 AS `studentScoreSum`,
 1 AS `testTotalScore`,
 1 AS `answerTime`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `studentdata`
--

/*!50001 DROP VIEW IF EXISTS `studentdata`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `studentdata` AS select `student`.`studentNo` AS `studentNO`,`student`.`school` AS `school`,`grade`.`grade` AS `grade`,`student`.`name` AS `name`,`gender`.`gender` AS `gender`,`student`.`username` AS `username`,`student`.`password` AS `password`,`student`.`phone` AS `phone`,`studenttoteacher`.`teacherno` AS `teacherNo`,`teacher`.`name` AS `teacherName` from ((((`student` left join `studenttoteacher` on((`student`.`studentNo` = `studenttoteacher`.`studentno`))) left join `grade` on((`student`.`grade` = `grade`.`idgrade`))) left join `gender` on((`student`.`gender` = `gender`.`idgender`))) left join `teacher` on((`studenttoteacher`.`teacherno` = `teacher`.`teacherno`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `havendonetest`
--

/*!50001 DROP VIEW IF EXISTS `havendonetest`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `havendonetest` AS select `test`.`id` AS `id`,`test`.`testno` AS `testno`,`test`.`suject` AS `suject`,`test`.`questionOrder` AS `questionOrder`,`test`.`questionNo` AS `questionNo`,`test`.`eachScore` AS `eachScore`,`test`.`teacherNo` AS `teacherNo`,`test`.`studentNo` AS `studentNo`,`test`.`time` AS `time` from `test` where `test`.`testno` in (select `answer`.`testno` from `answer`) is false */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `testgroupbytestno`
--

/*!50001 DROP VIEW IF EXISTS `testgroupbytestno`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `testgroupbytestno` AS select `testdata`.`testno` AS `testNo`,group_concat(distinct `testdata`.`suject` separator ',') AS `suject`,count(`testdata`.`questionorder`) AS `questionSum`,sum(`testdata`.`eachScore`) AS `scoreSum`,group_concat(distinct `testdata`.`teacherno` separator ',') AS `teacherNo`,group_concat(distinct `testdata`.`studentNo` separator ',') AS `studentNo`,group_concat(distinct `testdata`.`time` separator ',') AS `teacherTime` from `testdata` group by `testdata`.`testno` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `answerdata`
--

/*!50001 DROP VIEW IF EXISTS `answerdata`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `answerdata` AS select `answer`.`id` AS `id`,`answer`.`testno` AS `testno`,`answer`.`questionorder` AS `questionOrder`,`option`.`options` AS `answer`,`answer`.`answerTime` AS `answerTime` from (`answer` left join `option` on((`answer`.`answer` = `option`.`idoption`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `testresult`
--

/*!50001 DROP VIEW IF EXISTS `testresult`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `testresult` AS select `testdata`.`testno` AS `testno`,`testdata`.`teacherno` AS `teacherno`,`testdata`.`studentNo` AS `studentno`,`testdata`.`suject` AS `suject`,`testdata`.`questionorder` AS `questionorder`,`testdata`.`questionNo` AS `questionNo`,`questionall`.`topic` AS `topic`,`testdata`.`correctAnswer` AS `correctAnswer`,`answerdata`.`answer` AS `answer`,`testdata`.`eachScore` AS `eachScore`,if((`testdata`.`correctAnswer` = `answerdata`.`answer`),`testdata`.`eachScore`,0) AS `score`,`answerdata`.`answerTime` AS `answerTime` from ((`testdata` join `answerdata` on(((`testdata`.`testno` = `answerdata`.`testno`) and (`testdata`.`questionorder` = `answerdata`.`questionOrder`)))) left join `questionall` on((`testdata`.`questionNo` = `questionall`.`questionNo`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `testdata`
--

/*!50001 DROP VIEW IF EXISTS `testdata`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `testdata` AS select `test`.`testno` AS `testno`,`suject`.`suject` AS `suject`,`test`.`questionOrder` AS `questionorder`,`questionalldata`.`questionno` AS `questionNo`,`questionalldata`.`correctAnswer` AS `correctAnswer`,`test`.`eachScore` AS `eachScore`,`test`.`teacherNo` AS `teacherno`,`teacher`.`name` AS `teacherName`,`test`.`studentNo` AS `studentNo`,`student`.`name` AS `studentName`,`test`.`time` AS `time` from ((((`test` left join `suject` on((`test`.`suject` = `suject`.`idsuject`))) left join `questionalldata` on((`test`.`questionNo` = `questionalldata`.`questionno`))) left join `teacher` on((`test`.`teacherNo` = `teacher`.`teacherno`))) left join `student` on((`test`.`studentNo` = `student`.`studentNo`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `questionalldata`
--

/*!50001 DROP VIEW IF EXISTS `questionalldata`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `questionalldata` AS select `questionall`.`id` AS `id`,`questionall`.`questionNo` AS `questionno`,`suject`.`suject` AS `suject`,`grade`.`grade` AS `grade`,`questionall`.`topic` AS `topic`,`questionall`.`optionA` AS `optionA`,`questionall`.`optionB` AS `optionB`,`questionall`.`optionC` AS `optionC`,`questionall`.`optionD` AS `optionD`,`option`.`options` AS `correctAnswer` from (((`questionall` left join `suject` on((`questionall`.`suject` = `suject`.`idsuject`))) left join `grade` on((`questionall`.`grade` = `grade`.`idgrade`))) left join `option` on((`questionall`.`correctAnswer` = `option`.`idoption`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `testresultgroupbytestno`
--

/*!50001 DROP VIEW IF EXISTS `testresultgroupbytestno`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `testresultgroupbytestno` AS select `testresult`.`testno` AS `testNo`,group_concat(distinct `testresult`.`teacherno` separator ',') AS `teacherNo`,group_concat(distinct `testresult`.`studentno` separator ',') AS `studentNo`,group_concat(distinct `testresult`.`suject` separator ',') AS `suject`,sum(`testresult`.`score`) AS `studentScoreSum`,sum(`testresult`.`eachScore`) AS `testTotalScore`,group_concat(distinct `testresult`.`answerTime` separator ',') AS `answerTime` from `testresult` group by `testresult`.`testno` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-30 17:32:15
