USE [soccam]
GO

/****** Object:  View [dbo].[VW_SOCIOS_DEUDORES]    Script Date: 14/06/2019 10:38:36 a.m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


/* Obtiene todos los socios activos que deben la cuota del mes y año corriente */
CREATE VIEW [dbo].[VW_SOCIOS_DEUDORES]
AS
SELECT        pagosSocios_id AS ID_SOC_DEU, pagosSocios_socio AS ID_SOC, pagosSocios_estado AS SOD_ESTADO, pagosSocios_fechaVencimiento AS SOD_FECHA_VENCIMIENTO
FROM            dbo.pagosSocios AS p
WHERE        (pagosSocios_estado = 1) AND (pagosSocios_deleted = 0) AND (pagosSocios_anio = YEAR(GETDATE())) AND (pagosSocios_periodo = MONTH(GETDATE()) - 1)

GO


