package com.glureau.magicfragment_processor

import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.ksp.KotlinPoetKspPreview
import com.squareup.kotlinpoet.ksp.toClassName

@KotlinPoetKspPreview
class MagicFragmentVisitor(private val environment: SymbolProcessorEnvironment) : KSVisitorVoid() {

    override fun visitClassDeclaration(declaration: KSClassDeclaration, data: Unit) {
        val className = declaration.toClassName()

        val fileSpec: FileSpec = buildFileSpec(declaration)

        environment.codeGenerator.createNewFile(
            dependencies = Dependencies(
                aggregating = false,
                sources = arrayOf(declaration.containingFile!!)
            ),
            packageName = className.packageName,
            fileName = "Magic" + className.simpleName
        ).use { outputStream ->
            outputStream.writer()
                .use {
                    fileSpec.writeTo(it)
                }
        }
    }

}
