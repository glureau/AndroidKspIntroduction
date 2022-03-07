package com.glureau.magicfragment_processor

import com.glureau.magicfragment_lib.MagicFragment
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider
import com.google.devtools.ksp.symbol.KSAnnotated
import com.squareup.kotlinpoet.ksp.KotlinPoetKspPreview

@KotlinPoetKspPreview
class MagicFragmentCompiler(private val environment: SymbolProcessorEnvironment) : SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val symbols = resolver.getSymbolsWithAnnotation(MagicFragment::class.qualifiedName!!)
        val visitor = MagicFragmentVisitor(environment)
        symbols.forEach { it.accept(visitor, Unit) }
        return emptyList()
    }
}

@KotlinPoetKspPreview
class MagicFragmentCompilerProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor =
        MagicFragmentCompiler(environment)

}