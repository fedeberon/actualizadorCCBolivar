USE [soccam]
GO

/****** Object:  View [dbo].[VW_SOCIOS_RETRIBUTIVOS]    Script Date: 14/06/2019 10:39:54 a.m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


/* Obtiene todo los socios que abonaron la cuota del corriente mes y año */
CREATE VIEW [dbo].[VW_SOCIOS_RETRIBUTIVOS]
AS
SELECT        pagosSocios_id AS ID_SOC_RET, pagosSocios_socio AS ID_SOC, pagosSocios_estado AS SOR_ESTADO, pagosSocios_fechaVencimiento AS SOR_FECHA_VENCIMIENTO
FROM            dbo.pagosSocios AS p
WHERE        (pagosSocios_estado = 0) AND (pagosSocios_deleted = 0) AND (pagosSocios_anio = YEAR(GETDATE())) AND (pagosSocios_periodo = MONTH(GETDATE()) - 1)

GO


